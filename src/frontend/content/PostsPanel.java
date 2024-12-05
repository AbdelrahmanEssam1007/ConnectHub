/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package frontend.content;

import backend.content.*;
import backend.User;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

import utils.FileNames;
import utils.JSONFileReader;
import utils.JSONFileWriter;

/**
 *
 * @author Amr
 */
public class PostsPanel extends ContentPanel{
    public PostsPanel(User user, ContentManagerFactory contentManager, int width, int height){
        super(user, contentManager, width, height);
    }
}
