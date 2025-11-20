/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package pertemuan_14;

/**
 *
 * @author Ridho
 */
import java.io.FileWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import javax.persistence.*;

public class Utama extends javax.swing.JFrame {

    /**
     * Creates new form Utama
     */
    private static final Logger logger = Logger.getLogger(Utama.class.getName());

    public Utama() {
        initComponents();
        showTablePengguna();
        showTableBooking();
        tblPengguna.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblPengguna.getSelectedRow();

                int Id = Integer.parseInt(tblPengguna.getValueAt(row, 0).toString());
                String Nama = tblPengguna.getValueAt(row, 1).toString();
                String No = tblPengguna.getValueAt(row, 2).toString();
                String email = tblPengguna.getValueAt(row, 3).toString();

            }
        });
        tblBooking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = tblBooking.getSelectedRow();

                String idb = tblBooking.getValueAt(row, 0).toString();
                String idp = tblBooking.getValueAt(row, 1).toString(); // ID asli (hidden)
                String nama = tblBooking.getValueAt(row, 2).toString();
                String tanggal = tblBooking.getValueAt(row, 3).toString();
                String lapangan = tblBooking.getValueAt(row, 4).toString();
                String status = tblBooking.getValueAt(row, 5).toString();

            }
        });
    }

    private DefaultTableModel model;
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/TugasPBO2";
    String user = "postgres";
    String password = "er021105";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void showTablePengguna() {
        EntityManager em = Persistence.createEntityManagerFactory("Pertemuan_14PU").createEntityManager();
        Query q = em.createQuery("SELECT p FROM Pelanggan p ORDER BY p.idPelanggan");
        List<Pelanggan> hasil = q.getResultList();

        model = new DefaultTableModel(new String[]{"Id Pelanggan", "Nama Pelanggan", "No HP", "Email Pelanggan"}, 0);

        for (Pelanggan data : hasil) {
            Object[] baris = new Object[4];
            baris[0] = data.getIdPelanggan();
            baris[1] = data.getNama();
            baris[2] = data.getNoHp();
            baris[3] = data.getEmail();
            model.addRow(baris);
        }

        tblPengguna.setModel(model);
    }

    public void showTableBooking() {
        EntityManager em = Persistence
                .createEntityManagerFactory("Pertemuan_14PU")
                .createEntityManager();

        Query q = em.createQuery("SELECT b FROM Booking b ORDER BY b.idBooking");
        List<Booking> hasil = q.getResultList();

        model = new DefaultTableModel(
                new String[]{"ID Booking", "ID Pelanggan (hidden)", "Nama Pelanggan", "Tanggal", "Lapangan", "Status"},
                0
        );
        for (Booking data : hasil) {
            Object[] baris = new Object[6];
            baris[0] = data.getIdBooking();
            baris[1] = data.getIdPelanggan().getIdPelanggan(); // ID ASLI (hidden)
            baris[2] = data.getIdPelanggan().getNama();        // NAMA TAMPIL
            baris[3] = data.getTanggal();
            baris[4] = data.getLapangan();
            baris[5] = data.getStatus();
            model.addRow(baris);
        }
        tblBooking.setModel(model);
        tblBooking.getColumnModel().getColumn(1).setMinWidth(0);
        tblBooking.getColumnModel().getColumn(1).setMaxWidth(0);
        tblBooking.getColumnModel().getColumn(1).setWidth(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnInsertPelanggan = new javax.swing.JButton();
        btnUpdatePelanggan = new javax.swing.JButton();
        btnIDeletePelanggan = new javax.swing.JButton();
        btnUploadPelanggan = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPengguna = new javax.swing.JTable();
        btnPrintPelanggan = new javax.swing.JButton();
        btnClearPelanggan = new javax.swing.JButton();
        downloadPelangganCSV = new javax.swing.JToggleButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnUploadBooking = new javax.swing.JButton();
        btnPrintBooking = new javax.swing.JButton();
        btnInsertBooking = new javax.swing.JButton();
        btnUpdateBooking = new javax.swing.JButton();
        btnDeleteBooking = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblBooking = new javax.swing.JTable();
        btnClearBooking = new javax.swing.JButton();
        downloadBookingCSV = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 255, 102));

        jPanel3.setBackground(new java.awt.Color(102, 255, 102));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText(" APLIKASI BOOKING FUTSAL ORKAY ");

        jTabbedPane1.setBackground(new java.awt.Color(102, 255, 153));

        jPanel1.setBackground(new java.awt.Color(102, 255, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Data Pelanggan");

        btnInsertPelanggan.setText("Insert");
        btnInsertPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertPelangganActionPerformed(evt);
            }
        });

        btnUpdatePelanggan.setText("Update");
        btnUpdatePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdatePelangganActionPerformed(evt);
            }
        });

        btnIDeletePelanggan.setText("Delete");
        btnIDeletePelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIDeletePelangganActionPerformed(evt);
            }
        });

        btnUploadPelanggan.setText("Upload");
        btnUploadPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPelangganActionPerformed(evt);
            }
        });

        tblPengguna.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nama", "No HP", "Email"
            }
        ));
        tblPengguna.setColumnSelectionAllowed(true);
        jScrollPane3.setViewportView(tblPengguna);
        tblPengguna.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        btnPrintPelanggan.setText("Print");
        btnPrintPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintPelangganActionPerformed(evt);
            }
        });

        btnClearPelanggan.setText("Clear");
        btnClearPelanggan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearPelangganActionPerformed(evt);
            }
        });

        downloadPelangganCSV.setText("Donwload");
        downloadPelangganCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadPelangganCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnInsertPelanggan)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdatePelanggan)
                        .addGap(18, 18, 18)
                        .addComponent(btnIDeletePelanggan)
                        .addGap(18, 18, 18)
                        .addComponent(btnUploadPelanggan)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrintPelanggan)
                        .addGap(18, 32, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnClearPelanggan)
                    .addComponent(downloadPelangganCSV))
                .addGap(0, 28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(downloadPelangganCSV)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertPelanggan)
                    .addComponent(btnUpdatePelanggan)
                    .addComponent(btnIDeletePelanggan)
                    .addComponent(btnUploadPelanggan)
                    .addComponent(btnPrintPelanggan)
                    .addComponent(btnClearPelanggan))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tab Pelanggan", jPanel1);

        jPanel2.setBackground(new java.awt.Color(102, 255, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Data Booking");

        btnUploadBooking.setText("Upload");
        btnUploadBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadBookingActionPerformed(evt);
            }
        });

        btnPrintBooking.setText("Print");
        btnPrintBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintBookingActionPerformed(evt);
            }
        });

        btnInsertBooking.setText("Insert");
        btnInsertBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertBookingActionPerformed(evt);
            }
        });

        btnUpdateBooking.setText("Update");
        btnUpdateBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateBookingActionPerformed(evt);
            }
        });

        btnDeleteBooking.setText("Delete");
        btnDeleteBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteBookingActionPerformed(evt);
            }
        });

        tblBooking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id Booking", "Nama Pelanggan", "Tanggal", "Lapangan", "Status"
            }
        ));
        jScrollPane1.setViewportView(tblBooking);

        btnClearBooking.setText("Clear");
        btnClearBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearBookingActionPerformed(evt);
            }
        });

        downloadBookingCSV.setText("Donwload");
        downloadBookingCSV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadBookingCSVActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnUploadBooking)
                        .addGap(18, 18, 18)
                        .addComponent(btnPrintBooking)
                        .addGap(18, 18, 18)
                        .addComponent(btnInsertBooking)
                        .addGap(18, 18, 18)
                        .addComponent(btnUpdateBooking)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeleteBooking))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(234, 234, 234)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(downloadBookingCSV)
                    .addComponent(btnClearBooking))
                .addContainerGap(42, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(downloadBookingCSV))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnUploadBooking)
                    .addComponent(btnPrintBooking)
                    .addComponent(btnInsertBooking)
                    .addComponent(btnUpdateBooking)
                    .addComponent(btnDeleteBooking)
                    .addComponent(btnClearBooking))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Tab Booking", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 583, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(135, 135, 135)
                        .addComponent(jLabel1)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnInsertPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertPelangganActionPerformed
        InsertPengguna dlg = new InsertPengguna(this, true, this); // <== ini penting
        dlg.setVisible(true);

        // kalau dialog berhasil menyimpan data, reload tabel
        if (dlg.isSaved()) {
            showTablePengguna();
        }
    }//GEN-LAST:event_btnInsertPelangganActionPerformed

    private void btnUpdatePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdatePelangganActionPerformed
        // TODO add your handling code here:
        int row = tblPengguna.getSelectedRow();
        if (row != -1) {
            // ambil data dari tabel
            int Id = Integer.parseInt(tblPengguna.getValueAt(row, 0).toString());
            String Nama = tblPengguna.getValueAt(row, 1).toString();
            String No = tblPengguna.getValueAt(row, 2).toString();
            String email = tblPengguna.getValueAt(row, 3).toString();

            // buka dialog update
            UpdatePengguna dialog = new UpdatePengguna(this, true, this, Id, Nama, No, email);
            dialog.setVisible(true);

            // reload tabel setelah update
            if (dialog.isUpdated()) {
                showTablePengguna();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau diupdate dulu!");
        }
    }//GEN-LAST:event_btnUpdatePelangganActionPerformed

    private void btnIDeletePelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIDeletePelangganActionPerformed
        // TODO add your handling code here:
        int row = tblPengguna.getSelectedRow();
        if (row != -1) {
            // ambil data dari tabel
            int Id = Integer.parseInt(tblPengguna.getValueAt(row, 0).toString());
            String Nama = tblPengguna.getValueAt(row, 1).toString();
            String No = tblPengguna.getValueAt(row, 2).toString();
            String email = tblPengguna.getValueAt(row, 3).toString();

            // buka dialog delete
            DeletePengguna dialog = new DeletePengguna(this, true, this, Id, Nama, No, email);
            dialog.setVisible(true);

            // reload tabel setelah delete
            if (dialog.isUpdated()) {
                showTableBooking();
                showTablePengguna();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih data yang mau dihapus dulu!");
        }
    }//GEN-LAST:event_btnIDeletePelangganActionPerformed

    private void btnUploadPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPelangganActionPerformed

        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
            EntityManager em = emf.createEntityManager();

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ";";

                em.getTransaction().begin();
                while ((baris = br.readLine()) != null) {
                    if (baris.trim().isEmpty()) {
                        continue;
                    }

                    String[] data = baris.split(pemisah);
                    if (data.length < 4) {
                        continue;
                    }

                    String idpStr = data[0].trim();
                    String Nama = data[1].trim();
                    String No = data[2].trim();
                    String email = data[3].trim();

// Validasi data kosong
                    if (idpStr.isEmpty() || Nama.isEmpty() || No.isEmpty() || email.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Data tidak valid: " + baris);
                        continue;
                    }

                    try {
                        int Id = Integer.parseInt(idpStr);

                        // Lanjutkan proses simpan ke database
                        Pelanggan p = new Pelanggan();
                        p.setIdPelanggan(Id);
                        p.setNama(Nama);
                        p.setNoHp(No);
                        p.setEmail(email);

                        em.persist(p);

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "ID penerbit harus berupa angka! (Baris: " + baris + ")");
                        continue;
                    }
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Upload selesai dan berhasil!");
                showTablePengguna();

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(this, "Kesalahan saat upload: " + ex.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        }

    }//GEN-LAST:event_btnUploadPelangganActionPerformed

    private void btnPrintPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintPelangganActionPerformed
        JasperReport reports;

        String path = ".\\src\\pertemuan_14\\pelanggan.jasper";
        try {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
            }
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Pelanggan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintPelangganActionPerformed

    private void btnInsertBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertBookingActionPerformed

        InsertBooking dlg = new InsertBooking(this, true, this); // dialog booking full-day
        dlg.setVisible(true);

        if (dlg.isSaved()) {
            showTableBooking(); // refresh tabel Booking
        }

    }//GEN-LAST:event_btnInsertBookingActionPerformed

    private void btnDeleteBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteBookingActionPerformed
        int row = tblBooking.getSelectedRow();
        if (row != -1) {
            int idBooking = Integer.parseInt(tblBooking.getValueAt(row, 0).toString());
            int idPelanggan = Integer.parseInt(tblBooking.getValueAt(row, 1).toString());
            String tanggal = tblBooking.getValueAt(row, 2).toString();
            String lapangan = tblBooking.getValueAt(row, 3).toString();
            String status = tblBooking.getValueAt(row, 4).toString();

            DeleteBooking dialog = new DeleteBooking(this, true, this,
                    idBooking, idPelanggan, tanggal, lapangan, status);
            dialog.setVisible(true);

            if (dialog.isUpdated()) {
                showTableBooking();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Pilih booking yang mau dihapus dulu!");
        }
    }//GEN-LAST:event_btnDeleteBookingActionPerformed

    private void btnUpdateBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateBookingActionPerformed

        int row = tblBooking.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Pilih booking dulu!");
            return;
        }

        // Ambil data dari tabel
        int idBooking = Integer.parseInt(tblBooking.getValueAt(row, 0).toString());
        int idPelanggan = Integer.parseInt(tblBooking.getValueAt(row, 1).toString());
        String tanggal = tblBooking.getValueAt(row, 3).toString();
        String lapangan = tblBooking.getValueAt(row, 4).toString();
        String status = tblBooking.getValueAt(row, 5).toString();

        // Panggil dialog UpdateBooking dengan data dari tabel
        UpdateBooking dialog = new UpdateBooking(this, true, this, idBooking, idPelanggan, tanggal, lapangan, status);
        dialog.setVisible(true);

        // Refresh tabel setelah update
        if (dialog.isSaved()) {
            showTableBooking();
        }
    }//GEN-LAST:event_btnUpdateBookingActionPerformed

    private void btnUploadBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadBookingActionPerformed
        // TODO add your handling code here:
        JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
        int returnValue = jfc.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File filePilihan = jfc.getSelectedFile();
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
            EntityManager em = emf.createEntityManager();

            try (BufferedReader br = new BufferedReader(new FileReader(filePilihan))) {
                String baris;
                String pemisah = ";";

                em.getTransaction().begin();
                while ((baris = br.readLine()) != null) {
                    if (baris.trim().isEmpty()) {
                        continue;
                    }

                    String[] data = baris.split(pemisah);
                    if (data.length < 5) {
                        continue;
                    }

                    String idbStr = data[0].trim();
                    String idpStr = data[1].trim();
                    String tanggal = data[2].trim();
                    String lapangan = data[3].trim();
                    String status = data[4].trim();

                    // Validasi data kosong
                    if (idbStr.isEmpty() || idpStr.isEmpty() || tanggal.isEmpty()
                            || lapangan.isEmpty() || status.isEmpty()) {
                        JOptionPane.showMessageDialog(this, "Data tidak valid: " + baris);
                        continue;
                    }

                    try {
                        int idBooking = Integer.parseInt(idbStr);
                        int idPelanggan = Integer.parseInt(idpStr);

                        // cek pelanggan ada atau tidak
                        Pelanggan p = em.find(Pelanggan.class, idPelanggan);
                        if (p == null) {
                            JOptionPane.showMessageDialog(this, "Pelanggan dengan ID " + idPelanggan + " tidak ditemukan! Baris: " + baris);
                            continue;
                        }

                        // Buat object Booking
                        Booking b = new Booking();
                        b.setIdBooking(idBooking);
                        b.setIdPelanggan(p);
                        b.setTanggal(tanggal);
                        b.setLapangan(lapangan);
                        b.setStatus(status);

                        em.persist(b);

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "ID harus berupa angka! Baris: " + baris);
                        continue;
                    }
                }

                em.getTransaction().commit();
                JOptionPane.showMessageDialog(this, "Upload booking selesai dan berhasil!");
                showTableBooking(); // refresh tabel booking

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Gagal membaca file: " + ex.getMessage());
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(this, "Kesalahan saat upload: " + ex.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        }
    }//GEN-LAST:event_btnUploadBookingActionPerformed

    private void btnPrintBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintBookingActionPerformed
        JasperReport reports;

        String path = ".\\src\\pertemuan_14\\booking.jasper";
        try {
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(koneksi, user, password);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
            reports = (JasperReport) JRLoader.loadObjectFromFile(path);
            JasperPrint jprint = JasperFillManager.fillReport(path, null, conn);
            JasperViewer jviewer = new JasperViewer(jprint, false);
            jviewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            jviewer.setVisible(true);
        } catch (JRException ex) {
            Logger.getLogger(Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnPrintBookingActionPerformed

    private void btnClearPelangganActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearPelangganActionPerformed

        int confirm = JOptionPane.showConfirmDialog(null,
                "Yakin mau hapus semua data pelanggan (dan booking terkait)?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();

            // Hapus semua data pelanggan (booking ikut terhapus otomatis karena ON DELETE CASCADE)
            int deleted = em.createQuery("DELETE FROM Pelanggan").executeUpdate();

            em.getTransaction().commit();
            em.close();
            emf.close();

            // Refresh tabel di GUI
            showTablePengguna();
            showTableBooking(); // biar tabel booking juga ikut update kosong

            JOptionPane.showMessageDialog(null, deleted + " data pelanggan berhasil dihapus!");
        }
    }//GEN-LAST:event_btnClearPelangganActionPerformed

    private void btnClearBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearBookingActionPerformed
        // TODO add your handling code here:
        int confirm = JOptionPane.showConfirmDialog(null,
                "Yakin mau hapus semua data booking?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
            EntityManager em = emf.createEntityManager();
            try {
                em.getTransaction().begin();

                // Hapus semua data booking
                int deleted = em.createQuery("DELETE FROM Booking").executeUpdate();

                em.getTransaction().commit();

                // Refresh tabel
                showTableBooking();

                JOptionPane.showMessageDialog(null, deleted + " data booking berhasil dihapus!");
            } catch (Exception ex) {
                if (em.getTransaction().isActive()) {
                    em.getTransaction().rollback();
                }
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            } finally {
                em.close();
                emf.close();
            }
        }
    }//GEN-LAST:event_btnClearBookingActionPerformed

    private void downloadPelangganCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadPelangganCSVActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Simpan CSV Pelanggan");
        fc.setSelectedFile(new File("pelanggan.csv"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fc.getSelectedFile();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
        EntityManager em = emf.createEntityManager();

        try (FileWriter fw = new FileWriter(file)) {

            List<Pelanggan> list = em.createQuery("SELECT p FROM Pelanggan p", Pelanggan.class).getResultList();

            fw.write("id_pelanggan;nama;no_hp;email\n");

            for (Pelanggan p : list) {
                fw.write(p.getIdPelanggan() + ";");
                fw.write(p.getNama() + ";");
                fw.write(p.getNoHp() + ";");
                fw.write(p.getEmail() + "\n");
            }

            JOptionPane.showMessageDialog(this, "File CSV pelanggan berhasil dibuat!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_downloadPelangganCSVActionPerformed

    private void downloadBookingCSVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadBookingCSVActionPerformed
        JFileChooser fc = new JFileChooser();
        fc.setDialogTitle("Simpan CSV Booking");
        fc.setSelectedFile(new File("booking.csv"));
        if (fc.showSaveDialog(this) != JFileChooser.APPROVE_OPTION) {
            return;
        }

        File file = fc.getSelectedFile();

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Pertemuan_14PU");
        EntityManager em = emf.createEntityManager();

        try (FileWriter fw = new FileWriter(file)) {

            List<Booking> list = em.createQuery("SELECT b FROM Booking b", Booking.class).getResultList();

            fw.write("id_booking;id_pelanggan;tanggal;lapangan;status\n");

            for (Booking b : list) {
                fw.write(b.getIdBooking() + ";");
                fw.write(b.getIdPelanggan().getIdPelanggan() + ";");
                fw.write(b.getTanggal() + ";");
                fw.write(b.getLapangan() + ";");
                fw.write(b.getStatus() + "\n");
            }

            JOptionPane.showMessageDialog(this, "File CSV booking berhasil dibuat!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Gagal: " + e.getMessage());
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }//GEN-LAST:event_downloadBookingCSVActionPerformed

    private String csv(String text) {
        if (text == null) {
            return "";
        }
        return "\"" + text.replace("\"", "\"\"") + "\"";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new Utama().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClearBooking;
    private javax.swing.JButton btnClearPelanggan;
    private javax.swing.JButton btnDeleteBooking;
    private javax.swing.JButton btnIDeletePelanggan;
    private javax.swing.JButton btnInsertBooking;
    private javax.swing.JButton btnInsertPelanggan;
    private javax.swing.JButton btnPrintBooking;
    private javax.swing.JButton btnPrintPelanggan;
    private javax.swing.JButton btnUpdateBooking;
    private javax.swing.JButton btnUpdatePelanggan;
    private javax.swing.JButton btnUploadBooking;
    private javax.swing.JButton btnUploadPelanggan;
    private javax.swing.JToggleButton downloadBookingCSV;
    private javax.swing.JToggleButton downloadPelangganCSV;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tblBooking;
    private javax.swing.JTable tblPengguna;
    // End of variables declaration//GEN-END:variables
}
