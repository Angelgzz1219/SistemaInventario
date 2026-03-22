package inventario;

import javax.swing.*;

public class VentanaInventario extends JFrame {

    JTextField txtNombre, txtPrecio, txtExtra;
    JComboBox<String> comboTipo;
    JTextArea txtResultado;
    JButton btnAgregar;

    public VentanaInventario() {

        setTitle("Sistema de Inventario");
        setSize(500,500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new java.awt.Color(200,200,200));

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        lblNombre.setBounds(30,30,100,25);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150,30,150,30);
        txtNombre.setFont(new java.awt.Font("Chiller", java.awt.Font.PLAIN, 22));
        add(txtNombre);

        JLabel lblPrecio = new JLabel("Precio:");
        lblPrecio.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        lblPrecio.setBounds(30,70,100,30);
        add(lblPrecio);

        txtPrecio = new JTextField();
        txtPrecio.setBounds(150,70,150,30);
        txtPrecio.setFont(new java.awt.Font("Chiller", java.awt.Font.PLAIN, 22));
        add(txtPrecio);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        lblTipo.setBounds(30,110,100,35);
        add(lblTipo);

        comboTipo = new JComboBox<>();
        comboTipo.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        comboTipo.addItem("Electronico");
        comboTipo.addItem("Alimento");
        comboTipo.addItem("Ropa");
        comboTipo.setBounds(150,110,150,35);
        add(comboTipo);

        JLabel lblExtra = new JLabel("Dato extra:");
        lblExtra.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        lblExtra.setBounds(30,150,120,25);
        add(lblExtra);

        txtExtra = new JTextField();
        txtExtra.setBounds(150,150,150,35);
        txtExtra.setFont(new java.awt.Font("Chiller", java.awt.Font.PLAIN, 22));
        add(txtExtra);

        btnAgregar = new JButton("Agregar Producto");
        btnAgregar.setBackground(new java.awt.Color(0, 123, 255));
        btnAgregar.setFont(new java.awt.Font("Chiller", java.awt.Font.BOLD, 22));
        btnAgregar.setForeground(java.awt.Color.WHITE);
        btnAgregar.setBounds(100,190,180,30);
        add(btnAgregar);

        txtResultado = new JTextArea();
        txtResultado.setBounds(30,240,320,140);
        txtResultado.setBorder(BorderFactory.createTitledBorder("Resultado"));
        txtResultado.setFont(new java.awt.Font("Chiller", java.awt.Font.PLAIN, 22));
        add(txtResultado);

        btnAgregar.addActionListener(e -> procesar());
    }

    private void procesar() {

        String nombre = txtNombre.getText();
        double precio = Double.parseDouble(txtPrecio.getText());
        String extra = txtExtra.getText();
        String tipo = comboTipo.getSelectedItem().toString();

        Producto p = null;

        if (tipo.equals("Electronico")) {
            p = new Electronico(nombre, precio, Integer.parseInt(extra));
        }

        if (tipo.equals("Alimento")) {
            p = new Alimento(nombre, precio, extra);
        }

        if (tipo.equals("Ropa")) {
            p = new Ropa(nombre, precio, extra);
        }

        IVendible v = (IVendible) p;

        txtResultado.setText(
                "Producto: " + nombre +
                "\nTipo: " + tipo +
                "\nPrecio base: " + precio +
                "\nPrecio final: " + v.calcularPrecioFinal()
        );
    }
}
