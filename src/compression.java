import CompDecom.Compressor;
import CompDecom.Decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


class AppFrame extends JFrame implements ActionListener {
    JButton compressbutton;
    JButton DeccompressButton;
    AppFrame()
    {
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        compressbutton = new JButton("Select file to compress");
        compressbutton.setBounds(20,100,200,30);
        compressbutton.addActionListener(this);
        DeccompressButton = new JButton("Select file to Decompress");
        DeccompressButton.setBounds(250,100,200,30);
        DeccompressButton.addActionListener(this);
        this.add(compressbutton);
        this.add(DeccompressButton);
        this.setSize(500,1000);
        this.getContentPane().setBackground(Color.red);
        this.setVisible(true);


    }
    


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== compressbutton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.print(file);
                try {
                    Compressor.method(file);
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.toString());
                }
            }}
        if(e.getSource()==DeccompressButton)
        {
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);
            if(response == JFileChooser.APPROVE_OPTION) {
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());

                System.out.print(file);
                try{
                    Decompressor.method(file);
                }
                catch(Exception ee)
                {
                    JOptionPane.showMessageDialog(null,ee.toString());
                }
            }
        }
    }
}
