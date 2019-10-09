import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTree;
import javax.swing.JTextField;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class JavaFiles extends JFrame {

	private JPanel contentPane;
	public JFileChooser fc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaFiles frame = new JavaFiles();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JavaFiles() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 519, 338);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTree tree = new JTree();
		tree.setBounds(10, 11, 89, 199);
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("JTree") {
				{
					
				}
			}
		));
		contentPane.add(tree);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 11, 356, 199);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnNewButton = new JButton("Open");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc;
				FileReader fr=null;
				BufferedReader br=null;
				String s;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showOpenDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fr = new FileReader(path);
						br = new BufferedReader(fr);
						while((s=br.readLine())!=null) {
							textArea.append(s+"\n");
						}
					}
					br.close();
					fr.close();
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnNewButton.setBounds(31, 252, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSaveAs = new JButton("Save As");
		btnSaveAs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fc ;
				FileWriter fw =null;
				BufferedWriter bw=null;
				try {
					fc = new JFileChooser();
					int openDialog = fc.showSaveDialog(null);
					if(openDialog==JFileChooser.APPROVE_OPTION) {
						String path = fc.getSelectedFile().getAbsolutePath();
						fw = new FileWriter(path);
						bw = new BufferedWriter(fw);
						bw.write(textArea.getText());
						bw.flush();						
					}
				} catch (Exception e2) {
					// TODO: handle exception
					System.out.println("Error"+e2.getMessage());
				}
			}
		});
		btnSaveAs.setBounds(151, 252, 89, 23);
		contentPane.add(btnSaveAs);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {		
						fc = new JFileChooser();
						int openDialog = fc.showOpenDialog(null);
						if(openDialog==JFileChooser.APPROVE_OPTION) {
							String path = fc.getSelectedFile().getAbsolutePath();
							File xoaFile = new File(path);
							if(xoaFile.delete()) {
								JOptionPane.showMessageDialog(null, "Xoá file thành công !");
							} else {
								JOptionPane.showMessageDialog(null, "Xoá file thất bại !");
							}
						}	
			} catch (Exception ex) {
				System.out.print(ex.getMessage());
			}
			}
		});
		btnDelete.setBounds(266, 252, 89, 23);
		contentPane.add(btnDelete);
	}
}
