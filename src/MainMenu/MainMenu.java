package MainMenu;

import GUI.GUIPlayingBoard;
import GUI.PlayerInputDialog;
import GUI.GUILeaderboard;

public class MainMenu extends javax.swing.JFrame  
{
    public MainMenu() 
    {
        initComponents();
        setTitle("Connect 4! Main Menu");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        TwoPlayer = new javax.swing.JButton();
        LeaderboardButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Connect 4");

        jButton1.setText("One Player");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                singlePlayerButtonPressed(evt);
            }
        });

        jButton2.setText("Quit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonPressed(evt);
            }
        });

        TwoPlayer.setText("Two Player");
        TwoPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TwoPlayerActionPerformed(evt);
            }
        });

        LeaderboardButton.setText("Leaderboard");
        LeaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel1)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TwoPlayer, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LeaderboardButton, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addContainerGap(500, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {LeaderboardButton, TwoPlayer, jButton1, jButton2});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(111, 111, 111)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TwoPlayer)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(LeaderboardButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addContainerGap(280, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {LeaderboardButton, TwoPlayer, jButton1, jButton2});

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void singlePlayerButtonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_singlePlayerButtonPressed
        //PlayerInputDialog dialog = new PlayerInputDialog(this, false); //New instance
        PlayerInputDialog dialog = new PlayerInputDialog(this,false);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);                               //Set the panel to visible
        String player1Name = dialog.getPlayer1Name();          //Get player 1 name
        String player2Name = "Computer";
        
        if(player1Name!= null)                               //If player is not null then create the GUIPlaying board
        {
            //GUIPlayingBoard game = new GUIPlayingBoard(true, "Player 1", "Player 2");   //Set GUIPlayingBoard to true for single player 
            GUIPlayingBoard game = new GUIPlayingBoard(true, player1Name, player2Name);
            game.setLocationRelativeTo(null);
            game.setVisible(true);          //Set game to visible 
            this.dispose();                 //Close the main menu screen
        }   
    }//GEN-LAST:event_singlePlayerButtonPressed

    private void quitButtonPressed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonPressed
        System.exit(0);     //Exit application when quit button is pressed
    }//GEN-LAST:event_quitButtonPressed

    private void TwoPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TwoPlayerActionPerformed
        PlayerInputDialog dialog = new PlayerInputDialog(this, true);   //Set true for two player mode
        dialog.setLocationRelativeTo(null);                             //Set locatiion
        dialog.setVisible(true);                                        //Set player input panel to visible
        
        //Get methods for user name dialog 
        String player1Name = dialog.getPlayer1Name();           //Get player 1 name 
        String player2Name = dialog.getPlayer2Name();           //Get player 2 name
        
        GUIPlayingBoard game = new GUIPlayingBoard(false, player1Name, player2Name);      //New GUIPlayingBoard game, false for two player mode
        game.setLocationRelativeTo(null);
        game.setVisible(true);                                  //Set the game to visible
        this.dispose();                                         //Close the current main menu  
    }//GEN-LAST:event_TwoPlayerActionPerformed

    private void LeaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardButtonActionPerformed
        GUILeaderboard leaderboardGUI = new GUILeaderboard();
        leaderboardGUI.setVisible(true); // Display the leaderboard
    }//GEN-LAST:event_LeaderboardButtonActionPerformed

    public static void main(String args[]) 
    {
        // Nimbus removed because it opened and was cluttered
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                MainMenu menu = new MainMenu();
                //new MainMenu().setVisible(true);
                menu.setVisible(true);
                menu.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LeaderboardButton;
    private javax.swing.JButton TwoPlayer;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
 
}
