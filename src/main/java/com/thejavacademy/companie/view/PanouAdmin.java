package com.thejavacademy.companie.view;

import com.thejavacademy.companie.calculator.CalculatorTaxe;
import com.thejavacademy.companie.contribuabili.Contribuabil;
import com.thejavacademy.companie.contribuabili.RegistruContribuabili;

import javax.swing.*;

import static com.thejavacademy.companie.calculator.CalculatorTaxe.*;

public class PanouAdmin extends JPanel {


    private JList list;

    public PanouAdmin() {
        list = new JList(RegistruContribuabili.getContribuabili());
        list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        list.setVisibleRowCount(-1);
        add(list);
        setVisible(true);


        JButton butonAdaugare = new JButton("Adauga");
        butonAdaugare.addActionListener(e -> adaugaContribuabil());
        add(butonAdaugare);
        JButton butonStergere = new JButton("Sterge");
        butonStergere.addActionListener(e -> stergeContribuabile());
        add(butonStergere);
    }

    private void repaintList() {
        list.setListData(RegistruContribuabili.getContribuabili());
        repaint();
    }

    private void adaugaContribuabil() {
        JDialog jDialog = new JDialog();
        JPanel contentPane = new JPanel();
        jDialog.setContentPane(contentPane);
        contentPane.add(new JLabel("Nume: "));
        JTextField name = new JTextField("Nume");
        name.setSize(50, 20);
        name.setFocusable(true);
        contentPane.add(name);
        JButton ok = new JButton("OK");
        JComboBox comboBox = new JComboBox();
        comboBox.addItem(Departament.IT);
        comboBox.addItem(Departament.CONSTRUCTII);
        comboBox.addItem(Departament.GENERAL);
        contentPane.add(comboBox);
        contentPane.add(ok);
        ok.addActionListener(e -> {
            Departament departament = (Departament) comboBox.getSelectedItem();
            Contribuabil contribuabil = new Contribuabil(name.getText(), CalculatorTaxe.getCalculator(departament));
            RegistruContribuabili.adaugaContribuabil(contribuabil);
            jDialog.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            jDialog.dispose();
            repaintList();
        });
        jDialog.pack();
        jDialog.setVisible(true);
    }

    private void stergeContribuabile() {
        Contribuabil selectedValue = getContribuabil();
        if (selectedValue == null) {
            return;
        }
        RegistruContribuabili.stergeContribuabil(selectedValue);
        repaintList();

    }

    private Contribuabil getContribuabil() {
        return (Contribuabil) this.list.getSelectedValue();
    }




}
