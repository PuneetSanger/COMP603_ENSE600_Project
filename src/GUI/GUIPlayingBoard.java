package GUI;

import MainMenu.MainMenu;
import java.awt.BorderLayout;
import java.util.Random;
import javax.swing.JOptionPane;

/*
    This class creates the playing board for the connect 4 by adding the board grid to
    a jpanel. This class also handles the actions on the buttons alongside the ai
    move method
*/

public class GUIPlayingBoard extends javax.swing.JFrame 
{

    private final BoardGrid boardGrid;
    private int currentPlayer = 1;                  //Player 1 starts
    private boolean isSinglePlayer = false;         //Create AI player just like in assignment 1
    private final String player1Name;
    private final String player2Name;
    
//    public GUIPlayingBoard(boolean singlePlayer)    
//    {
//        initComponents();
//        setTitle("Connect 4");                          //Add title to top of frame
//        jPanel1.setLayout(new BorderLayout());
//        boardGrid = new BoardGrid();                    //Create BoardGrid
//        jPanel1.add(boardGrid, BorderLayout.CENTER);    //Add BoardGrid to JPanel
//        this.isSinglePlayer = singlePlayer;             //Sets GUI playing board for single player mode 
//        this.player1Name = player1Name;
//        this.player2Name = player2Name;
//        
//        System.out.println("Player1 Name:"+ this.player1Name);
//        System.out.println("Player2Name"+ this.player2Name);
//    }

    public GUIPlayingBoard(boolean isSinglePlayer, String player1Name, String player2Name)
    {
        initComponents();
        setTitle("Connect 4");                          //Add title to top of frame
        jPanel1.setLayout(new BorderLayout());
        boardGrid = new BoardGrid();                    //Create BoardGrid
        jPanel1.add(boardGrid, BorderLayout.CENTER);    //Add BoardGrid to JPanel
        this.isSinglePlayer = isSinglePlayer;
        this.player1Name = player1Name;
        //this.player2Name = player2Name;
        
        //Set player 2 name to computer during single player mode
        this.player2Name = isSinglePlayer ? "Computer" : player2Name;
        
        //Debugging statements 
        System.out.println("Player1 Name: " + player1Name);
        System.out.println("Player2Name: "+ player2Name);
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    private String getWinner()
    {
        if(isSinglePlayer && currentPlayer == 2)
        {
            return player2Name;
        }
        return (currentPlayer == 1) ? player1Name: player2Name;
    }
    
    //Button actions
    private void handleButtonAction(int col) 
    {
        if (boardGrid.dropCoin(col, currentPlayer)) 
        {
            if (boardGrid.checkWin()) 
            {
                //Winner print statement            
                JOptionPane.showMessageDialog(this, getWinner() + " wins!");           
                boardGrid.resetBoard(); //Reset for new game
            } 
            else if (boardGrid.isBoardFull()) 
            {
                JOptionPane.showMessageDialog(this, "It's a draw!");    //If board is full print statement
                boardGrid.resetBoard();                                 //Reset for new game
            }
            
            else 
            {
                currentPlayer = (currentPlayer == 1) ? 2 : 1; // Switch turns between the two players
            }
            
            
            if (isSinglePlayer && currentPlayer == 2)
            {
                //disableButtons();   //Disable buttons so user cannot input before the computer 
                AIMove();           //Trigger a move from the ai when in single player
            }
            
            //enableButtons();
        } 
        else 
        {
            //Column is full print statement 
            JOptionPane.showMessageDialog(this, "Column full! Choose another one.");
        }
    }
    
    private void AIMove()       //Create a method that handles the movement of the computer 
    {                           //for single player mode
        int aiMove;                 
        Random random = new Random();
        
        do
        {
           aiMove = random.nextInt(7);       //Set move of the computer to a integer between 0 and 6
        } while (!boardGrid.dropCoin(aiMove, currentPlayer));
        
            if (boardGrid.checkWin())
                {   
                    //Ai winner print statement 
                    JOptionPane.showMessageDialog(this, "The Computer wins!");
                    boardGrid.resetBoard();     //Reset for new game    
                }
        
                else if (boardGrid.isBoardFull())
                {
                    JOptionPane.showMessageDialog(this, "It's a draw!");    //If board is full print statement
                    boardGrid.resetBoard(); //Reset for new game
                }
        
                else 
                {
                    currentPlayer = 1;      //Switch back to the human player 
                }         
    }
   
    


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Restart = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        MainMenu = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 597, Short.MAX_VALUE)
        );

        jButton1.setText("1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("2");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("3");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("4");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("5");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("6");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("7");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        Restart.setText("Restart");
        Restart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RestartActionPerformed(evt);
            }
        });

        jButton9.setText("Quit");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitButton(evt);
            }
        });

        MainMenu.setText("MainMenu");
        MainMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MainMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Restart, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(MainMenu)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Restart, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MainMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        //Counter counter = new Counter();
//        ActionListener listener = new MyActionListener(counter);
//        jButton1.addActionListener(listener);   
//        jPanel1.add(counter);  // Add the counter to the panel so it's visible
//        jPanel1.revalidate();  // Refresh the panel
//        jPanel1.repaint();
//        
        //jButton1.addActionListener(MyActionListener);
        handleButtonAction(0);
       
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Button 2 has been pressed");
        handleButtonAction(1);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Button 3 has been pressed");
        handleButtonAction(2);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Button 4 has been pressed");
        handleButtonAction(3);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        //ystem.out.println("Button 5 has been pressed");
        handleButtonAction(4);
       
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Button 6 has been pressed");
        handleButtonAction(5);
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        //System.out.println("Button 7 has been pressed");
        handleButtonAction(6);
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void RestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RestartActionPerformed
        // TODO add your handling code here:
        boardGrid.resetBoard();             //This method resets the board
        
    }//GEN-LAST:event_RestartActionPerformed

    private void QuitButton(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitButton
        // TODO add your handling code here:
        System.exit(0);         //Quit the application
    }//GEN-LAST:event_QuitButton

    private void MainMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MainMenuActionPerformed
        // TODO add your handling code here:
        this.dispose();                         //This closes the GUI playing board. 
        MainMenu menu = new MainMenu();         //This allows the user to return
        menu.setVisible(true);                  //to the main menu after pressing
        menu.setLocationRelativeTo(null);       //the button.
    }//GEN-LAST:event_MainMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GUIPlayingBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUIPlayingBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUIPlayingBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUIPlayingBoard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            @Override
            public void run() 
            {
                new GUIPlayingBoard(true,"Player 1", "Player 2").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MainMenu;
    private javax.swing.JButton Restart;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton9;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables


}
