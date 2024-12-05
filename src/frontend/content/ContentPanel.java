package frontend.content;

import backend.User;
import backend.content.Content;
import backend.content.ContentManagerFactory;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static utils.ImageUtils.scaleImageIcon;

public class ContentPanel extends JPanel{
    protected final User user;
    protected final ContentManagerFactory contentManagerFactory;
    protected final JPanel contentContainer;

    public ContentPanel(User user, ContentManagerFactory contentManagerFactory, int width, int height) {
        /*Initializing class variables*/
        this.user = user;
        this.contentManagerFactory = contentManagerFactory;

        /*Configuring main content panel*/
        setLayout(new BorderLayout());
        setSize(width, height);
        setBackground(Color.WHITE);

        /*Configuring container*/
        contentContainer = new JPanel();
        contentContainer.setBackground(Color.WHITE);
        contentContainer.setLayout(new BoxLayout(contentContainer, BoxLayout.Y_AXIS));

        /*Configuring scroll*/
        JScrollPane scrollContent = new JScrollPane(contentContainer);
        add(scrollContent, BorderLayout.CENTER);

        /*Loading Content*/
        loadContent();
    }

    /*Loading method*/
    public void loadContent(){
        contentManagerFactory.readFromDB();
        List<Content> content = contentManagerFactory.getContent();
        for(Content x : content)
            addContent(x);
    }

    public void addContent(Content content){
        contentContainer.add(createContentPanel(content));
        contentContainer.revalidate();
        contentContainer.repaint();
    }

    /*Creating panel from post*/
    public JPanel createContentPanel(Content content){
        /*Configuring content panel*/
        JPanel contentPanel = new JPanel();
        contentPanel.setBackground(Color.WHITE);
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
            /*Adding padding*/
        contentPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        /*Configuring content header*/
        DateTimeFormatter contentDateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        JLabel header = new JLabel(content.getUsername() + "    " + content.getPostDate().format(contentDateFormat));
        header.setFont(new Font("Arial", Font.BOLD, 14));
        contentPanel.add(header);

        /*Configuring content text*/
        if(content.returnText() != null){
            JLabel text =  new JLabel(content.returnText());
            text.setFont(new Font("Arial", Font.PLAIN, 12));
            contentPanel.add(text);
        }

        /*Configuring content image*/
        if(content.returnImagePath() != null){
            ImageIcon scaledImage = scaleImageIcon(content.returnImagePath(), getWidth() - 60);
            contentPanel.add(new JLabel(scaledImage));
        }

        return contentPanel;
    }
}