/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.DistributorRole;

import business.Enterprise.CDCEnterprise;
import business.Enterprise.Enterprise;
import business.Inventory.Batch;
import business.order.Order;
import business.order.OrderItem;
import business.Organization.ClinicOrganization;
import business.Organization.DistributorOrganization;
import business.Organization.Organization;
import business.WorkRequest.ShipmentOrder;
import business.WorkRequest.ClinicShipmentWorkRequest;
import business.WorkRequest.ProviderWorkRequest;
import business.WorkRequest.WorkRequest;
import business.business.Business;
import business.network.Network;
import business.userAccounts.UserAccount;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.time;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Rachita
 */
public class ProcessOrderRequestJPanel extends javax.swing.JPanel {

    JPanel userProcessContainer;
    private Enterprise enterprise;
    private Order order;
    private WorkRequest request;
    CDCEnterprise cDCEnterprise; 
    WorkRequest newRequest;
    WorkRequest wq;
    Organization organization;
    private boolean isCheckedOut;
    DistributorOrganization distOrganization;
    UserAccount userAccount;
    Business business;
    ProviderWorkRequest providerRequest;
    ClinicShipmentWorkRequest clinicRequest;
    ShipmentOrder shipmentreq;
    Batch batchOrdered;
     
    public ProcessOrderRequestJPanel(JPanel userProcessContainer, Order order, WorkRequest request,Enterprise enterprise,Organization organization,UserAccount userAccount,Business business) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.order = order;
        this.request = request;
        this.enterprise = enterprise;
        cDCEnterprise = (CDCEnterprise) enterprise;
        this.organization=organization;
        this.userAccount=userAccount;
        this.business = business;
         if(organization instanceof DistributorOrganization)
        distOrganization = (DistributorOrganization)organization;
        txtOrder.setText(order.getOrderID() + "");
        populateOrderJTable();
        vCodeJLabel.setVisible(false);

        if (isCheckedOut == false) {
           // newRequest = new ShipmentOrder();
            shipmentreq = new ShipmentOrder();
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    private void populateOrderJTable() {
        DefaultTableModel dtm = (DefaultTableModel) OrderJTable.getModel();
        dtm.setRowCount(0);
        if (!order.getOrderitemList().isEmpty()) {
            for (OrderItem item : order.getOrderitemList()) {
                Object row[] = new Object[4];
                row[0] = order;
                row[1] = item;
                row[2] = item.getQuantity();
                row[3] = item.getDaysOfOrderPlaced();
                dtm.addRow(row);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        OrderJTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtOrder = new javax.swing.JTextField();
        btnLookup = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        InventoryJTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        nameJLabel = new javax.swing.JLabel();
        qtyJLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vCodeJLabel = new javax.swing.JLabel();
        btnAddOrder = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        BatchJTable = new javax.swing.JTable();
        btnRequest = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        shipmentOrderTable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnRemove = new javax.swing.JButton();
        btnFinalizw = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("        Process Order Requests");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 20, 350, 50));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jButton1.setText("<<Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 110, 100, 30));

        OrderJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "OrderID", "Vaccine Name", "Vaccine Quantity", "Schedule"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(OrderJTable);
        if (OrderJTable.getColumnModel().getColumnCount() > 0) {
            OrderJTable.getColumnModel().getColumn(0).setResizable(false);
            OrderJTable.getColumnModel().getColumn(1).setResizable(false);
            OrderJTable.getColumnModel().getColumn(2).setResizable(false);
            OrderJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, 1180, 110));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setText("Order ID");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 100, 70, 30));

        txtOrder.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        txtOrder.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        txtOrder.setEnabled(false);
        add(txtOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 100, 160, 30));

        btnLookup.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnLookup.setText("Look Up");
        btnLookup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLookupActionPerformed(evt);
            }
        });
        add(btnLookup, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 100, 30));

        InventoryJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Vaccine Code", "Vaccine Name", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InventoryJTable.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                InventoryJTableMouseWheelMoved(evt);
            }
        });
        jScrollPane2.setViewportView(InventoryJTable);
        if (InventoryJTable.getColumnModel().getColumnCount() > 0) {
            InventoryJTable.getColumnModel().getColumn(0).setResizable(false);
            InventoryJTable.getColumnModel().getColumn(1).setResizable(false);
            InventoryJTable.getColumnModel().getColumn(2).setResizable(false);
        }

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 1180, 60));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setText("  Select from National Inventory  ");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 340, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setText("Vaccine Name");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 120, 20));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setText("Vaccine Quantity");
        add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 110, 20));

        nameJLabel.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        nameJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(nameJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 290, 130, 20));

        qtyJLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(qtyJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 290, 120, 20));
        add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 320, 120, 20));
        add(vCodeJLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 360, 60, 20));

        btnAddOrder.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnAddOrder.setText("Add to Shipment Order>>");
        btnAddOrder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrderActionPerformed(evt);
            }
        });
        add(btnAddOrder, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 480, 220, 30));

        BatchJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Batch ID", "Vaccine ID", "Vaccine Name", "Batch Size", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(BatchJTable);
        if (BatchJTable.getColumnModel().getColumnCount() > 0) {
            BatchJTable.getColumnModel().getColumn(0).setResizable(false);
            BatchJTable.getColumnModel().getColumn(1).setResizable(false);
            BatchJTable.getColumnModel().getColumn(2).setResizable(false);
            BatchJTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 480, 1050, 160));

        btnRequest.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRequest.setText("Send Request for Inventory>>");
        btnRequest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRequestActionPerformed(evt);
            }
        });
        add(btnRequest, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 520, 220, 30));

        btnRefresh.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRefresh.setText("Refresh>>");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        add(btnRefresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 560, 140, 30));

        shipmentOrderTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Shipment OrderID", "Batch ID", "VAccine Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(shipmentOrderTable);

        add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 700, 1050, 130));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setText("Select Batch for Shipment Order");
        jLabel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 450, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("View The Shipment OrderItem List");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 670, -1, -1));

        btnRemove.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnRemove.setText("Remove>>");
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });
        add(btnRemove, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 700, 180, 30));

        btnFinalizw.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnFinalizw.setText("Finalize Order>>");
        btnFinalizw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizwActionPerformed(evt);
            }
        });
        add(btnFinalizw, new org.netbeans.lib.awtextra.AbsoluteConstraints(1110, 740, 180, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);

    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnLookupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLookupActionPerformed

        // TODO add your handling code here:
        int selectedRow = OrderJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
            OrderItem selectedItem = (OrderItem) OrderJTable.getValueAt(selectedRow, 1);
            nameJLabel.setText(selectedItem.getVaccine().getName());
            qtyJLabel.setText(selectedItem.getQuantity() + "");
            vCodeJLabel.setText(selectedItem.getVaccine().getCode());

            DefaultTableModel dtm = (DefaultTableModel) InventoryJTable.getModel();
            dtm.setRowCount(0);
            Object[] row = new Object[3];
            row[0] = vCodeJLabel.getText();
            row[1] = nameJLabel.getText();
            int finalqty = 0;

            for (Batch batch : cDCEnterprise.getInventory().getBatchList()) {
                if (batch.getVaccine().getName().equals(nameJLabel.getText()) && batch.getValue()==null) {
                    finalqty += batch.getVaccine().getQuantity();

                }
            }

            row[2] = finalqty;
            dtm.addRow(row);
            //refreshBatchTable();
             populateBatchJTable();
        }
       

    }//GEN-LAST:event_btnLookupActionPerformed

    private void populateBatchJTable() {
        DefaultTableModel model = (DefaultTableModel) BatchJTable.getModel();
        model.setRowCount(0);

        for (Batch batch : cDCEnterprise.getInventory().getBatchList()) {       
            if (batch.getVaccine().getName().equals(nameJLabel.getText()) && null==batch.getValue()) {
                Object row[] = new Object[5];
                row[0] = batch;
                row[1] = batch.getVaccine();
                row[2] = batch.getVaccine().getName();
                row[3] = batch.getVaccine().getQuantity();
                row[4] = batch.getVaccine().getQuantity() * batch.getVaccine().getPrice();
                model.addRow(row);

            }
        }
    }
    private void InventoryJTableMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_InventoryJTableMouseWheelMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_InventoryJTableMouseWheelMoved

    private void btnAddOrderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrderActionPerformed

        // TODO add your handling code here:
        populateShipmentRequest();
        btnRefresh.setEnabled(false);


    }//GEN-LAST:event_btnAddOrderActionPerformed

    private void populateShipmentRequest() {
        int selectedRow = BatchJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
            batchOrdered = (Batch) BatchJTable.getValueAt(selectedRow, 0);

            DefaultTableModel dtm = (DefaultTableModel) shipmentOrderTable.getModel();
            dtm.setRowCount(0);
           // ShipmentOrder shipmentOrder = new ShipmentOrder();
            //ShipmentOrder
           // shipmentreq = (ShipmentOrder)newRequest;
            shipmentreq.getBatchList().add(batchOrdered);
            shipmentreq.setitemOrderRequest(request);
            
            
            for (Batch b : shipmentreq.getBatchList()) {
                Object[] row = new Object[4];
                row[0] = b;
                row[1] = b.getVaccine().getCode();
                row[2] = b.getVaccine().getName();
                row[3] = b.getVaccine().getPrice() * b.getVaccine().getQuantity();
                dtm.addRow(row);
            }
        }
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed

        // TODO add your handling code here:
       // populateBatchJTable();
        refreshShipmentTable();
    }//GEN-LAST:event_btnRefreshActionPerformed

    public void refreshShipmentTable() {
        int rowCount = shipmentOrderTable.getRowCount();
        DefaultTableModel model = (DefaultTableModel) shipmentOrderTable.getModel();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
//    public void refreshBatchTable() {
//        int rowCount = BatchJTable.getRowCount();
//        DefaultTableModel model = (DefaultTableModel) BatchJTable.getModel();
//        for (int i = rowCount - 1; i >= 0; i--) {
//            model.removeRow(i);
//        }
//    }
    private void btnFinalizwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizwActionPerformed
        // TODO add your handling code here:
        
                
        if (!shipmentreq.getBatchList().isEmpty()) {
            
          //  distOrganization.getCatalog().addOrder(shipmentreq);
            
            request.setStatus("Shipped");
            request.setSender(userAccount);
            request.setResolveDate(time());
            batchOrdered.setValue("AddedByDist");
            dispatchOrder();
            JOptionPane.showMessageDialog(null, "Shipmment order placed Successfully! Please refresh the table before proceeding with a fresh order");
             btnRefresh.setEnabled(true);
            //   btnView.setEnabled(true);
        } else {
            batchOrdered.setValue("");
            JOptionPane.showMessageDialog(null, "Error Checking out.");
            btnRefresh.setEnabled(true);
        }
        isCheckedOut = true;
        shipmentreq = new ShipmentOrder();
    }//GEN-LAST:event_btnFinalizwActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        // TODO add your handling code here:
        int selectedrow = shipmentOrderTable.getSelectedRow();
        if (selectedrow < 0) {
            JOptionPane.showMessageDialog(null, "Please select an item order.");
            return;
        }
        //get the order item
        shipmentreq = (ShipmentOrder) shipmentOrderTable.getValueAt(selectedrow, 0);
        Batch batch = (Batch) BatchJTable.getValueAt(selectedrow, 0);
        
        //remove
        shipmentreq.getBatchList().remove(batch);
        populateShipmentRequest();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void btnRequestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRequestActionPerformed
        // TODO add your handling code here:
        int selectedRow = OrderJTable.getSelectedRow();

        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(null, "Please select a row.");
        } else {
        OrderItem selectedItem = (OrderItem) OrderJTable.getValueAt(selectedRow, 1);
        
        SubmitManufRequestJPanel panel = new SubmitManufRequestJPanel(userProcessContainer,userAccount,enterprise,selectedItem.getVaccine());
        userProcessContainer.add("SubmitManufRequestJPanel",panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
        }
        
    }//GEN-LAST:event_btnRequestActionPerformed

    
    private void dispatchOrder(){
        //ShipmentOrder shipRequest = new ShipmentOrder();
       // newRequest = shipmentreq.getitemOrderRequest();
        
        if(request instanceof ProviderWorkRequest){
             System.out.println("ProviderWorkRequest" );
            providerRequest = (ProviderWorkRequest) request;
        }
           
        else if(request instanceof ClinicShipmentWorkRequest){
            
            System.out.println("ClinicShipmentWorkRequest");
            clinicRequest = (ClinicShipmentWorkRequest) request;
        }
             
        
        for(Network country: business.getNetworkList()){
            System.out.println("country" + country);
            for(Enterprise cdc: country.getEnterpriseDirectory().getEnterpriseList()){
                System.out.println("cdc " + cdc + " : cDCEnterprise.getName() ::" + cDCEnterprise.getName());
                if(cdc.getName().equals(cDCEnterprise.getName())){
                    System.out.println("country list : " + country.getNetWorkList().size());
                    for(Network state: country.getNetWorkList()){
                        System.out.println("state " + state.getState() + " :size " + state.getNetWorkList().size() );
                        for(Network city: state.getNetWorkList()){
                            System.out.println("city : " + city.getCity() + " : size :" + city.getEnterpriseDirectory().getEnterpriseList().size());
                            for(Enterprise provider: city.getEnterpriseDirectory().getEnterpriseList()){
                                 System.out.println("provider " + provider.getName() + "request " + request );
                                 
                                 System.out.println("provider.getName() " + (providerRequest instanceof ProviderWorkRequest));
                                 
                                 
                                 
                                if((providerRequest instanceof ProviderWorkRequest) && provider.getName().equals(providerRequest.getOrginalprovider())){
                                    
                                    System.out.println("providerRequest.getOrginalprovider()" + providerRequest.getOrginalprovider());
                                    
                                    System.out.println("inside providerRequest");
                                    UserAccount OriginalProvider  = new UserAccount();
                                    OriginalProvider.setUserName(providerRequest.getOrginalprovider());
                                    request.setReceiver(OriginalProvider);
                                    shipmentreq.setReceiver(OriginalProvider);
                                    provider.getWorkQueue().getWorkRequestList().add(shipmentreq);
                                    userAccount.getWorkQueue().getWorkRequestList().add(shipmentreq);
                                    
                                }
                                else if(request instanceof ClinicShipmentWorkRequest){
                                    for(Organization ClinicOrg: provider.getOrganizationDirectory().getOrganizationList()){
                                        if(ClinicOrg instanceof ClinicOrganization && ClinicOrg.getName().equals(clinicRequest.getOrginalClinic())){
                                            System.out.println("inside clinicRequest ");
                                            //ClinicOrg.getWorkQueue().getWorkRequestList().add(shipmentreq);
                                            UserAccount OriginalProvider  = new UserAccount();
                                            OriginalProvider.setUserName(clinicRequest.getOrginalprovider());
                                            request.setReceiver(OriginalProvider);
                                            shipmentreq.setReceiver(OriginalProvider);
                                            provider.getWorkQueue().getWorkRequestList().add(shipmentreq);
                                            userAccount.getWorkQueue().getWorkRequestList().add(shipmentreq);
                                        }
                                    }
//                                    //&& provider.getName().equals(clinicRequest.getOrginalprovider())})
                                  }
                                    
                                }
                            }
                        }
                    }
                }
            }
        }
       
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable BatchJTable;
    private javax.swing.JTable InventoryJTable;
    private javax.swing.JTable OrderJTable;
    private javax.swing.JButton btnAddOrder;
    private javax.swing.JButton btnFinalizw;
    private javax.swing.JButton btnLookup;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnRequest;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel nameJLabel;
    private javax.swing.JLabel qtyJLabel;
    private javax.swing.JTable shipmentOrderTable;
    private javax.swing.JTextField txtOrder;
    private javax.swing.JLabel vCodeJLabel;
    // End of variables declaration//GEN-END:variables
}
