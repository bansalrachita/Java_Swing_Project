/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package userInterface.systemAdminRole;

import userInterface.enterpriseUserAccounts.AddAdminJPanel;
import userInterface.enterpriseUserAccounts.UpdateAdminJPanel;
import business.Enterprise.Enterprise;
import business.business.Business;
import business.network.Network;
import business.userAccounts.UserAccount;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rachita
 */
public class ManageUserAccounts extends javax.swing.JPanel {

    /**
     * Creates new form ManageUserAccounts
     */
    JPanel userProcessContainer;
    private Business business;
    
    public ManageUserAccounts(JPanel userProcessContainer,Business business) {
        initComponents();
        this.userProcessContainer=userProcessContainer;
        this.business=business;
        populatecmbNetwork();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        cmbNetwork = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        cmbEnterprise = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        UserAccountJTable = new javax.swing.JTable();
        btnAddAdmin = new javax.swing.JButton();
        btnUpdateAdmin = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("         Manage Center of Disease Control Admin Accounts");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 60, 640, 36));

        jLabel2.setText("Network");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 60, 20));

        cmbNetwork.setMaximumRowCount(80);
        cmbNetwork.setToolTipText("");
        cmbNetwork.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cmbNetworkMousePressed(evt);
            }
        });
        cmbNetwork.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNetworkActionPerformed(evt);
            }
        });
        add(cmbNetwork, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 210, 190, 30));

        jLabel3.setText("Enterprise");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 260, 70, 30));

        add(cmbEnterprise, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 260, 190, 30));

        UserAccountJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "UserName", "Password", "Status", "Role", "EmployeeName", "Country"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(UserAccountJTable);
        if (UserAccountJTable.getColumnModel().getColumnCount() > 0) {
            UserAccountJTable.getColumnModel().getColumn(0).setResizable(false);
            UserAccountJTable.getColumnModel().getColumn(1).setResizable(false);
            UserAccountJTable.getColumnModel().getColumn(4).setResizable(false);
            UserAccountJTable.getColumnModel().getColumn(5).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 870, 240));

        btnAddAdmin.setText("Add  Admin >>");
        btnAddAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddAdminActionPerformed(evt);
            }
        });
        add(btnAddAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 400, 140, 30));

        btnUpdateAdmin.setText("Update Admin>>");
        btnUpdateAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateAdminActionPerformed(evt);
            }
        });
        add(btnUpdateAdmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 440, 140, 30));

        btnRefresh.setText("Refresh>>");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(980, 480, 140, 30));

        btnBack.setText("<<Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });
        add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 80, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void populateJTable(){
        DefaultTableModel dtm = (DefaultTableModel) UserAccountJTable.getModel();
        dtm.setRowCount(0);
        for(Network country: business.getNetworkList()){
            for(Enterprise enterprise:country.getEnterpriseDirectory().getEnterpriseList()){
                for(UserAccount user:enterprise.getUserAccountDirectory().getUserAccountList()){
                     Object[] row = new Object[6];
                     row[0] = user;
                     row[1]=user.getPassword();
                     row[2]=user.getStatus();
                     row[3]=user.getRole();
                     row[4]=user.getEmployee().getName();
                     row[5]=country.getCountry();
                     dtm.addRow(row);
                }
            }
        }
       
    }
    private void populatecmbNetwork(){
        cmbNetwork.removeAllItems();
       for(Network network: business.getNetworkList()){
           cmbNetwork.addItem(network);
       } 
    }
    private void populateEnterprise(Network country){
       cmbEnterprise.removeAllItems();
        for(Network network : business.getNetworkList()){
            if(network.getCountry().equals(country.getCountry())){
                for(Enterprise enterprise: network.getEnterpriseDirectory().getEnterpriseList()){
                    cmbEnterprise.addItem(enterprise);
                }
            }
        }
    }
    private void btnUpdateAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateAdminActionPerformed
        int selectedRow = UserAccountJTable.getSelectedRow();
        if(selectedRow<0){
            JOptionPane.showMessageDialog(null,"Please Select a UserAccount.");
            return;
        }
        UserAccount user = (UserAccount) UserAccountJTable.getValueAt(selectedRow, 0);
        UpdateAdminJPanel panel = new UpdateAdminJPanel(userProcessContainer,user);
        userProcessContainer.add("UpdateCDCJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnUpdateAdminActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        populateJTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnAddAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddAdminActionPerformed
        Enterprise enterprise = (Enterprise) cmbEnterprise.getSelectedItem();
        AddAdminJPanel panel = new AddAdminJPanel(userProcessContainer, enterprise,business);
        userProcessContainer.add("AddCDCAdminJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddAdminActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
       userProcessContainer.remove(this);
       CardLayout layout = (CardLayout) userProcessContainer.getLayout();
       layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void cmbNetworkMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmbNetworkMousePressed
        
    }//GEN-LAST:event_cmbNetworkMousePressed

    private void cmbNetworkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNetworkActionPerformed
      Network network = (Network) cmbNetwork.getSelectedItem();
        populateEnterprise(network);
    }//GEN-LAST:event_cmbNetworkActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable UserAccountJTable;
    private javax.swing.JButton btnAddAdmin;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnUpdateAdmin;
    private javax.swing.JComboBox cmbEnterprise;
    private javax.swing.JComboBox cmbNetwork;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
