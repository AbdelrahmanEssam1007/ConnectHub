package frontend.content;

import backend.User;
import backend.content.Comment;
import backend.content.Content;
import backend.content.ContentFacade;
import backend.groups.GroupManager;
import backend.groups.GroupRole;
import utils.ModernScrollBarUI;

import javax.swing.*;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static utils.ImageUtils.scaleImageIcon;

public class ContentPanel extends JPanel{
    protected final User user;
    protected final ContentFacade contentFacade;
    protected final JPanel contentContainer;
    protected final String type;
    protected final JPanel scrollContentPanel;

    public ContentPanel(User user, ContentFacade contentFacade, int width, int height, String type) {
        /*Initializing class variables*/
        this.user = user;
        this.contentFacade = contentFacade;
        this.type = type;

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

        JScrollBar sb = scrollContent.getVerticalScrollBar();
        sb.setOpaque(false);
        sb.setForeground(new Color(33, 140, 206));
        sb.setPreferredSize(new Dimension(20, 15));
        sb.setUI(new ModernScrollBarUI());

        scrollContentPanel = (JPanel) scrollContent.getViewport().getView();
        add(scrollContent, BorderLayout.CENTER);

        /*Loading Content*/
        loadContent(type);
    }

    /*Loading method*/
    public void loadContent(String type){
        contentFacade.readFromDB(type);
        List<Content> content = contentFacade.getContent();
        contentContainer.removeAll();

        if (content.isEmpty()) {
            JLabel noContentLabel = new JLabel("No content available.");
            noContentLabel.setFont(new Font("Arial", Font.ITALIC, 14));
            noContentLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
            contentContainer.add(noContentLabel);
        } else {
            for (Content x : content) {
                addContent(x);
            }
        }

        contentContainer.revalidate();
        contentContainer.repaint();
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
        JButton removeContentButton;
        JButton editContentButton;
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(header);
        GroupRole role = GroupManager.getInstance().getGroupRole(type, user.getUserId());

        if(user.getUserId().equals(content.getAuthorID()) ||
        role == GroupRole.ADMIN || role == GroupRole.PRIMARY_ADMIN){
            removeContentButton = new JButton("Remove");
            removeContentButton.addActionListener(e -> {
                contentFacade.removeContent(content);
                loadContent(type);
            });
            headerPanel.add(removeContentButton);
            editContentButton = new JButton("Edit");
            editContentButton.addActionListener(e -> {
                String newText = JOptionPane.showInputDialog("Please input new text.");
                if(newText != null){
                    /*TODO: add editing image*/
                    contentFacade.editContent(content.getPostID(), newText, null);
                    loadContent(type);
                }
            });
            headerPanel.add(editContentButton);
        }
        headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        contentPanel.add(headerPanel);

        /*Configuring content text*/
        if(content.returnText() != null){
            JTextArea text = new JTextArea(content.returnText());
            text.setFont(new Font("Arial", Font.PLAIN, 12));
            text.setEditable(false);
            text.setLineWrap(true);
            text.setWrapStyleWord(true);
            text.setOpaque(false);
            text.setBorder(null);

            JPanel textPanel = new JPanel();
            textPanel.setLayout(new BorderLayout());
            textPanel.setOpaque(false);
            textPanel.add(text, BorderLayout.CENTER);
            textPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

            contentPanel.add(textPanel);
        }

        /*Configuring content image*/
        if(content.returnImagePath() != null){
            ImageIcon scaledImage = scaleImageIcon(content.returnImagePath(), getWidth() - 60);
            JLabel imageLabel = new JLabel(scaledImage);
            imageLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            contentPanel.add(imageLabel);
        }

        /*Adding comment button*/
        JButton commentButton = new JButton("Comment");
        headerPanel.add(commentButton);
        commentButton.addActionListener(e -> {
            String commentText = JOptionPane.showInputDialog("Your Comment: ");
            if(commentText != null&& !commentText.isEmpty())
                contentFacade.addComment(user.getUserId(), content.getPostID(), commentText);
        });

        /*Add show comments button*/
        JButton showCommentsButton = new JButton("Show Comments");
        headerPanel.add(showCommentsButton);
        showCommentsButton.addActionListener(e -> {
            List<Comment> commentsList = contentFacade.returnComments(content.getPostID());
            System.out.println("Comments Size: " + commentsList.size());
            CommentsPanel commentsPanel = new CommentsPanel(commentsList, 0);
        });

        /*Add like counter*/
        JLabel likeCounter = new JLabel();
        headerPanel.add(likeCounter);
        likeCounter.setText("Likes: " + content.getLikes().size());

        /*Add like button*/
        JButton likeButton = new JButton();
        if(contentFacade.searchLikesByAuthorID(user.getUserId(), content.getPostID()) == null){
            likeButton.setText("Like");
            likeButton.setBackground(new java.awt.Color(102, 102, 102));
        }else{
            likeButton.setText("Liked");
            likeButton.setBackground(new java.awt.Color(0, 153, 255));
        }
        headerPanel.add(likeButton);
        likeButton.addActionListener(e -> {
            if(contentFacade.searchLikesByAuthorID(user.getUserId(), content.getPostID()) != null){
                likeButton.setBackground(new java.awt.Color(102, 102, 102));
                likeButton.setText("Like");
                contentFacade.removeLike(user.getUserId(), content.getPostID());
                Content newContent = contentFacade.searchContentByID(content.getPostID());
                likeCounter.setText("Likes: " + newContent.getLikes().size());
            }
            else{
                likeButton.setBackground(new java.awt.Color(0, 153, 255));
                likeButton.setText("Liked");
                contentFacade.addLike(user.getUserId(), content.getPostID());
                Content newContent = contentFacade.searchContentByID(content.getPostID());
                likeCounter.setText("Likes: " + newContent.getLikes().size());
            }
            revalidate();
            repaint();
        });
        revalidate();
        repaint();
        return contentPanel;
    }
}
