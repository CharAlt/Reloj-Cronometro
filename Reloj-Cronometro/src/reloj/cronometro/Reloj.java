package reloj.cronometro;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import javax.swing.Timer;

/**
 *
 * @author ca-pc
 */
public class Reloj extends javax.swing.JFrame {

    Timer tiempo;    
    private LocalTime hora;
    private String tipo, horas, minutos, segundos;
    private boolean volver = true;
    private int horaI, minuto, segs;
    private Principal pri; 
            
    public Reloj(Principal p) {
        initComponents();
        setLocationRelativeTo(null);
        setTitle("Reloj");
        tiempo = new Timer(1000, acciones);
        pri = p;
    }
    
    public void iniciar(){
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabel = new javax.swing.JPanel();
        var1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jlabel.setBackground(new java.awt.Color(255, 255, 255));

        var1.setBackground(new java.awt.Color(0, 0, 153));
        var1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        var1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton2.setText("detener");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setText("Iniciar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setText("Volver al Menu");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jlabelLayout = new javax.swing.GroupLayout(jlabel);
        jlabel.setLayout(jlabelLayout);
        jlabelLayout.setHorizontalGroup(
            jlabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlabelLayout.createSequentialGroup()
                .addGroup(jlabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jlabelLayout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(var1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jlabelLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jlabelLayout.setVerticalGroup(
            jlabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jlabelLayout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addGroup(jlabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(var1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jlabelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)
                    .addComponent(jButton3))
                .addContainerGap(79, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        tiempo.stop();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        tiempo.start();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        this.setVisible(false);
        tiempo.stop();
        var1.setText("");
        pri.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private ActionListener acciones = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           calcular();
           var1.setText(horas+":"+minutos+":"+segundos+":"+tipo);
        }
    }; 

    private void calcular(){
         hora = LocalTime.now();

            horaI = hora.getHour();
            tipo = "AM";
            if (horaI > 12) {
                tipo = "PM";
            }

            if (horaI <= 9) {
                horas = "0" + String.valueOf(horaI);
            } else {
                horas = String.valueOf(horaI);
            }

            minuto = hora.getMinute();
            if (minuto <= 9) {
                minutos = "0" + String.valueOf(minuto);
            } else {
                minutos = String.valueOf(minuto);
            }

            segs = hora.getSecond();
            if (segs <= 9) {
                segundos = "0" + String.valueOf(segs);
            } else {
                segundos = String.valueOf(segs);
            }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jlabel;
    private javax.swing.JLabel var1;
    // End of variables declaration//GEN-END:variables
}
