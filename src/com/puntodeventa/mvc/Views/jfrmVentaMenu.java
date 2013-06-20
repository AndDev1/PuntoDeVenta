package com.puntodeventa.mvc.Views;

import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.global.Util.TagHelper;
import com.puntodeventa.global.Util.ValidacionForms;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

/*
 * @author Jorge Eduardo Hernández
 */
public class jfrmVentaMenu extends javax.swing.JDialog {

    private jfrmVenta parent;
    ValidacionForms valid = new ValidacionForms();
    private String optionSelected = "";

    public jfrmVentaMenu(jfrmVenta parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        configureControls();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jbtnCut = new javax.swing.JButton();
        jbtnCancelOrder = new javax.swing.JButton();
        jpnlTitle = new javax.swing.JPanel();
        jlblSelectOptionTitle = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jlblIcon = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaHelpText = new javax.swing.JTextArea();
        jBtnOk = new javax.swing.JButton();
        jbtnCashCount = new javax.swing.JButton();
        jbtnCredit = new javax.swing.JButton();
        jbtnPayWithCredit = new javax.swing.JButton();
        jBtnCancel = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });

        jbtnCut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/modificar.png"))); // NOI18N
        jbtnCut.setText("Corte de caja");
        jbtnCut.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCut.setName("jbtnCut"); // NOI18N

        jbtnCancelOrder.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/cancelar.png"))); // NOI18N
        jbtnCancelOrder.setText("Cancelar venta");
        jbtnCancelOrder.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCancelOrder.setName("jbtnCancelOrder"); // NOI18N

        jpnlTitle.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlblSelectOptionTitle.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jlblSelectOptionTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jlblSelectOptionTitle.setText("Seleccione una opción:");

        javax.swing.GroupLayout jpnlTitleLayout = new javax.swing.GroupLayout(jpnlTitle);
        jpnlTitle.setLayout(jpnlTitleLayout);
        jpnlTitleLayout.setHorizontalGroup(
            jpnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnlTitleLayout.createSequentialGroup()
                .addComponent(jlblSelectOptionTitle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnlTitleLayout.setVerticalGroup(
            jpnlTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlblSelectOptionTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setFocusable(false);

        jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png"))); // NOI18N

        jtaHelpText.setEditable(false);
        jtaHelpText.setBackground(new java.awt.Color(227, 227, 227));
        jtaHelpText.setColumns(20);
        jtaHelpText.setLineWrap(true);
        jtaHelpText.setRows(3);
        jtaHelpText.setWrapStyleWord(true);
        jtaHelpText.setAutoscrolls(false);
        jtaHelpText.setBorder(null);
        jtaHelpText.setFocusable(false);
        jScrollPane2.setViewportView(jtaHelpText);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jlblIcon)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jBtnOk.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconDone.png"))); // NOI18N
        jBtnOk.setText("Aceptar");
        jBtnOk.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnOk.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnOk.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnOkActionPerformed(evt);
            }
        });

        jbtnCashCount.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/arqueo.png"))); // NOI18N
        jbtnCashCount.setText("Arqueo de caja");
        jbtnCashCount.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCashCount.setName("jbtnCashCount"); // NOI18N

        jbtnCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/credito.png"))); // NOI18N
        jbtnCredit.setText("Crear crédito");
        jbtnCredit.setToolTipText("");
        jbtnCredit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnCredit.setName("jbtnCredit"); // NOI18N

        jbtnPayWithCredit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/paywith_credit.png"))); // NOI18N
        jbtnPayWithCredit.setText("Pagar a crédito");
        jbtnPayWithCredit.setToolTipText("");
        jbtnPayWithCredit.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jbtnPayWithCredit.setName("jbtnPayWithCredit"); // NOI18N

        jBtnCancel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jBtnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/iconCritical.png"))); // NOI18N
        jBtnCancel.setText("Cancelar");
        jBtnCancel.setMaximumSize(new java.awt.Dimension(113, 50));
        jBtnCancel.setMinimumSize(new java.awt.Dimension(185, 39));
        jBtnCancel.setPreferredSize(new java.awt.Dimension(185, 39));
        jBtnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpnlTitle, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jbtnCashCount, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnCancelOrder, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnCut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jbtnCredit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jbtnPayWithCredit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnlTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jBtnOk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jBtnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbtnCancelOrder)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCut)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCashCount)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnCredit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnPayWithCredit)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnOkActionPerformed
        int op;
        switch (this.optionSelected) {
            case "jbtnCancelOrder":
                op = valid.msjOption(TagHelper.getTag("jfrmVentaMenu.CancelOrderConfirmation"), TagHelper.getTag("jfrmVentaMenu.CancelOrderTitle"));
                if (op == 0) {
                    parent.restartControls();
                    this.jbtnCancelOrder.setEnabled(false);
                    this.setTags();
                }
                break;
            case "jbtnCut":
                if (parent.jtblVenta.getRowCount() > 0) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenu.CutCancelOrderMsg"));
                } else {
                    dispose();
                    jfrmVentaMenuCorte corte = new jfrmVentaMenuCorte(parent, true);
                    corte.setVisible(true);
                }
                break;
            case "jbtnCashCount":
                if (parent.jtblVenta.getRowCount() > 0) {
                    valid.msjWarn(TagHelper.getTag("jfrmVentaMenu.CutCancelOrderMsg"));
                } else {
                    dispose();
                    jfrmVentaMenuArqueo arqueo = new jfrmVentaMenuArqueo(parent, true);
                    arqueo.setVisible(true);
                }
                break;
            case "jbtnCredit":
                dispose();
                jfrmVentaMenuCreditForm creditForm = new jfrmVentaMenuCreditForm(parent, true);
                creditForm.setVisible(true);
                break;
            case "jbtnPayWithCredit":
                // Option in which we print two tickets. A simple credit.
                dispose();
                break;

        }
    }//GEN-LAST:event_jBtnOkActionPerformed

    private void jBtnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelActionPerformed
        dispose();
    }//GEN-LAST:event_jBtnCancelActionPerformed

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        if (evt.getKeyChar() == KeyEvent.VK_ESCAPE) {
            this.dispose();
        }
    }//GEN-LAST:event_formKeyTyped
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnCancel;
    private javax.swing.JButton jBtnOk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton jbtnCancelOrder;
    private javax.swing.JButton jbtnCashCount;
    private javax.swing.JButton jbtnCredit;
    private javax.swing.JButton jbtnCut;
    private javax.swing.JButton jbtnPayWithCredit;
    private javax.swing.JLabel jlblIcon;
    private javax.swing.JLabel jlblSelectOptionTitle;
    private javax.swing.JPanel jpnlTitle;
    private javax.swing.JTextArea jtaHelpText;
    // End of variables declaration//GEN-END:variables

    private void configureControls() {
        if (parent.jtblVenta.getRowCount() == 0) {
            this.jbtnCancelOrder.setEnabled(false);
            this.jbtnCredit.setEnabled(false);
        }
        this.setTags();
        this.setLocationRelativeTo(null);

        java.awt.event.ActionListener al = new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                displayHelp(evt.getSource());
            }
        };

        this.jbtnCancelOrder.addActionListener(al);
        this.jbtnCut.addActionListener(al);
        this.jbtnCashCount.addActionListener(al);
        this.jbtnCredit.addActionListener(al);


        KeyStroke esc = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        Action escPressed = new AbstractAction("esc") {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        };
        jlblSelectOptionTitle.getActionMap().put("escPressed", escPressed);
        jlblSelectOptionTitle.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, "escPressed");

        boolean isMenuEnabled;

        isMenuEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.canelOrder_enabled").toString());
        this.jbtnCancelOrder.setVisible(isMenuEnabled);

        isMenuEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.cashCount_enabled").toString());
        this.jbtnCashCount.setVisible(isMenuEnabled);

        isMenuEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.cashCut_enabled").toString());
        this.jbtnCut.setVisible(isMenuEnabled);

        isMenuEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.credit_enabled").toString());
        this.jbtnCredit.setVisible(isMenuEnabled);

        isMenuEnabled = Boolean.valueOf(ParamHelper.getParam("jfrmVentaMenu.payWithCredit_enabled").toString());
        this.jbtnPayWithCredit.setVisible(isMenuEnabled);

    }

    private void setTags() {
        this.optionSelected = "";
        this.jlblSelectOptionTitle.setText(TagHelper.getTag("jfrmVentaMenu.selectOptionTitle"));
        this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.helpInstructions"));
        this.jlblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/help.png")));

        this.jbtnCancelOrder.setText(TagHelper.getTag("jfrmVentaMenu.CancelOrderTitle"));
        this.jbtnCut.setText(TagHelper.getTag("jfrmVentaMenu.Cut"));
        this.jbtnCashCount.setText(TagHelper.getTag("jfrmVentaMenu.CashCount"));
        this.jbtnCredit.setText(TagHelper.getTag("jfrmVentaMenu.credit"));
        this.jbtnPayWithCredit.setText(TagHelper.getTag("jfrmVentaMenu.payWithcredit"));
    }

    private void displayHelp(Object obj) {

        JButton btn = (JButton) obj;

        Icon icon = btn.getIcon();
        this.jlblIcon.setIcon(icon);

        optionSelected = btn.getName();

        switch (optionSelected) {
            case "jbtnCancelOrder":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CancelOrderHelp"));
                break;
            case "jbtnCut":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CutHelp"));
                break;
            case "jbtnCashCount":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.CashCountHelp"));
                break;
            case "jbtnCredit":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.creditHelp"));
                break;
            case "jbtnPayWitgCredit":
                this.jtaHelpText.setText(TagHelper.getTag("jfrmVentaMenu.payWithcreditHelp"));
                break;
        }
    }
}