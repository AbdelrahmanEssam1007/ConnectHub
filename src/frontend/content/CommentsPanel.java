package frontend.content;

import backend.UserDB;
import backend.content.Comment;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;

public class CommentsPanel extends JDialog {
    private JPanel contentPane;
    private JButton nextButton;
    private JButton buttonCancel;
    private JPanel commentPanel;
    private List<Comment> commentsList;
    private Comment currentComment;
    private int index;
    private boolean outOfIndexFlag = false;

    public CommentsPanel(List<Comment> commentsList, int index) {
        System.out.println("Inside constructor");
        setContentPane(contentPane);
        setSize(400,200);
        setLocationRelativeTo(null);

        /*Managing comment variables*/
        this.commentsList = commentsList;
        this.index = index;
        this.currentComment = commentsList.get(index);
        if(index == commentsList.size()-1){
            outOfIndexFlag = true;
            nextButton.setVisible(false);
        }

        /*Putting comment in panel*/
        commentPanel.setLayout(new BoxLayout(commentPanel, BoxLayout.Y_AXIS));
        String username = UserDB.getInstance().searchUserByUserId(currentComment.getAuthorId()).getUserName();
        JLabel header = new JLabel(username);
        header.setFont(new Font("Arial", Font.BOLD, 14));
        commentPanel.add(header);
        JLabel commentText =  new JLabel(currentComment.getText());
        commentText.setFont(new Font("Arial", Font.PLAIN, 12));
        commentPanel.add(commentText);
        revalidate();
        repaint();

        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onNext();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        /*Finishing touches*/
        getRootPane().setDefaultButton(nextButton);
        setVisible(true);
    }

    private void onNext() {
        CommentsPanel nextComment = new CommentsPanel(commentsList, index+1);
        dispose();
    }

    private void onCancel() {
        dispose();
    }

}
