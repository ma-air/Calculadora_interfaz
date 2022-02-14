package calculadora.Calculadora_interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Calculadora extends JFrame {

	private JPanel todoPanel, abajo, arriba;
	JLabel label = new JLabel();
	String numeroString = "";
	String tipoOperacion;
	int operacion;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora frame = new Calculadora();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calculadora() {
		setBackground(Color.GRAY);
		setResizable(false);
		setTitle("Calculadora");

		todoPanel = new JPanel();
		todoPanel.setLayout(new BorderLayout());

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 342, 283);

		arriba = new JPanel();
		arriba.setFont(new Font("Tahoma", Font.BOLD, 49));
		arriba.setBackground(Color.WHITE);
		arriba.setBorder(new LineBorder(Color.LIGHT_GRAY, 6));
		GridBagLayout gblArriba = new GridBagLayout();

		arriba.setLayout(gblArriba);

		label = new JLabel("");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 7, 7);
		gbc_label.gridwidth = 2;
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		arriba.add(label, gbc_label);

		abajo = new JPanel();
		abajo.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(todoPanel);
		GridBagLayout gblAbajo = new GridBagLayout();
		abajo.setLayout(gblAbajo);

		JButton btn_7 = new JButton("7");
		btn_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_7.getText());
			}
		});
		btn_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_7.setBackground(Color.LIGHT_GRAY);
		btn_7.setForeground(Color.BLUE);
		GridBagConstraints gbc_7 = new GridBagConstraints();
		gbc_7.fill = GridBagConstraints.BOTH;
		gbc_7.insets = new Insets(5, 0, 7, 7);
		gbc_7.gridx = 0;
		gbc_7.gridy = 0;
		abajo.add(btn_7, gbc_7);

		JButton btn_8 = new JButton("8");
		btn_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_8.getText());
			}
		});
		btn_8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_8.setBackground(Color.LIGHT_GRAY);
		btn_8.setForeground(Color.BLUE);
		GridBagConstraints gbc_8 = new GridBagConstraints();
		gbc_8.fill = GridBagConstraints.BOTH;
		gbc_8.insets = new Insets(5, 0, 7, 7);
		gbc_8.gridx = 1;
		gbc_8.gridy = 0;
		abajo.add(btn_8, gbc_8);

		JButton btn_9 = new JButton("9");
		btn_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_9.getText());
			}
		});
		btn_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_9.setBackground(Color.LIGHT_GRAY);
		btn_9.setForeground(Color.BLUE);
		GridBagConstraints gbc_9 = new GridBagConstraints();
		gbc_9.fill = GridBagConstraints.BOTH;
		gbc_9.insets = new Insets(5, 0, 7, 7);
		gbc_9.gridx = 2;
		gbc_9.gridy = 0;
		abajo.add(btn_9, gbc_9);

		JButton btn_Mas_Menos = new JButton("+/-");
		btn_Mas_Menos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (positivo_negativo()) {
					label.setText(" -" + label.getText());
				}	else {
					label.getText().replace(" -", "");
				}
				

			}
		});
		btn_Mas_Menos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Mas_Menos.setBackground(Color.LIGHT_GRAY);
		btn_Mas_Menos.setForeground(Color.WHITE);
		GridBagConstraints gbc_Mas_Menos = new GridBagConstraints();
		gbc_Mas_Menos.fill = GridBagConstraints.BOTH;
		gbc_Mas_Menos.insets = new Insets(5, 0, 7, 7);
		gbc_Mas_Menos.gridx = 3;
		gbc_Mas_Menos.gridy = 0;
		abajo.add(btn_Mas_Menos, gbc_Mas_Menos);

		JButton btn_Back = new JButton("→");
		
		btn_Back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText("");
			}
		});
		btn_Back.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Back.setBackground(Color.LIGHT_GRAY);
		btn_Back.setForeground(Color.WHITE);
		GridBagConstraints gbc_Back = new GridBagConstraints();
		gbc_Back.fill = GridBagConstraints.BOTH;
		gbc_Back.insets = new Insets(5, 0, 7, 7);
		gbc_Back.gridx = 4;
		gbc_Back.gridy = 0;
		abajo.add(btn_Back, gbc_Back);

		JButton btn_4 = new JButton("4");
		btn_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_4.getText());
			}
		});
		btn_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_4.setBackground(Color.LIGHT_GRAY);
		btn_4.setForeground(Color.BLUE);
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.fill = GridBagConstraints.BOTH;
		gbc_4.insets = new Insets(0, 0, 7, 7);
		gbc_4.gridx = 0;
		gbc_4.gridy = 1;
		abajo.add(btn_4, gbc_4);

		JButton btn_5 = new JButton("5");
		btn_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_5.getText());
			}
		});
		btn_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_5.setBackground(Color.LIGHT_GRAY);
		btn_5.setForeground(Color.BLUE);
		GridBagConstraints gbc_5 = new GridBagConstraints();
		gbc_5.fill = GridBagConstraints.BOTH;
		gbc_5.insets = new Insets(0, 0, 7, 7);
		gbc_5.gridx = 1;
		gbc_5.gridy = 1;
		abajo.add(btn_5, gbc_5);

		JButton btn_6 = new JButton("6");
		btn_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_6.getText());
			}
		});
		btn_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_6.setBackground(Color.LIGHT_GRAY);
		btn_6.setForeground(Color.BLUE);
		GridBagConstraints gbc_6 = new GridBagConstraints();
		gbc_6.fill = GridBagConstraints.BOTH;
		gbc_6.insets = new Insets(0, 0, 7, 7);
		gbc_6.gridx = 2;
		gbc_6.gridy = 1;
		abajo.add(btn_6, gbc_6);

		JButton btn_Mult = new JButton("x");
		btn_Mult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_Mult.getText());
			}
		});
		btn_Mult.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Mult.setBackground(Color.GRAY);
		btn_Mult.setForeground(Color.WHITE);
		GridBagConstraints gbc_Mult = new GridBagConstraints();
		gbc_Mult.fill = GridBagConstraints.BOTH;
		gbc_Mult.insets = new Insets(0, 0, 7, 7);
		gbc_Mult.gridx = 3;
		gbc_Mult.gridy = 1;
		abajo.add(btn_Mult, gbc_Mult);

		JButton btn_Div = new JButton("÷");
		btn_Div.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + "/");
			}
		});
		btn_Div.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Div.setBackground(Color.GRAY);
		btn_Div.setForeground(Color.WHITE);
		GridBagConstraints gbc_Div = new GridBagConstraints();
		gbc_Div.fill = GridBagConstraints.BOTH;
		gbc_Div.insets = new Insets(0, 0, 7, 7);
		gbc_Div.gridx = 4;
		gbc_Div.gridy = 1;
		abajo.add(btn_Div, gbc_Div);

		JButton btn_1 = new JButton("1");
		btn_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_1.getText());
			}
		});
		btn_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_1.setBackground(Color.LIGHT_GRAY);
		btn_1.setForeground(Color.BLUE);
		GridBagConstraints gbc_1 = new GridBagConstraints();
		gbc_1.fill = GridBagConstraints.BOTH;
		gbc_1.insets = new Insets(0, 0, 7, 7);
		gbc_1.gridx = 0;
		gbc_1.gridy = 2;
		abajo.add(btn_1, gbc_1);

		JButton btn_2 = new JButton("2");
		btn_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_2.getText());
			}
		});
		btn_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_2.setBackground(Color.LIGHT_GRAY);
		btn_2.setForeground(Color.BLUE);
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.fill = GridBagConstraints.BOTH;
		gbc_2.insets = new Insets(0, 0, 7, 7);
		gbc_2.gridx = 1;
		gbc_2.gridy = 2;
		abajo.add(btn_2, gbc_2);

		JButton btn_3 = new JButton("3");
		btn_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_3.getText());
			}
		});
		btn_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_3.setBackground(Color.LIGHT_GRAY);
		btn_3.setForeground(Color.BLUE);
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.fill = GridBagConstraints.BOTH;
		gbc_3.insets = new Insets(0, 0, 7, 7);
		gbc_3.gridx = 2;
		gbc_3.gridy = 2;
		abajo.add(btn_3, gbc_3);

		JButton btn_Res = new JButton("-");
		btn_Res.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_Res.getText());
			}
		});
		btn_Res.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Res.setBackground(Color.GRAY);
		btn_Res.setForeground(Color.WHITE);
		GridBagConstraints gbc_Res = new GridBagConstraints();
		gbc_Res.fill = GridBagConstraints.BOTH;
		gbc_Res.insets = new Insets(0, 0, 7, 7);
		gbc_Res.gridx = 3;
		gbc_Res.gridy = 2;
		abajo.add(btn_Res, gbc_Res);

		JButton btn_Igu = new JButton("=");

		btn_Igu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_Igu.getText());
				
			}
		});
		btn_Igu.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Igu.setForeground(Color.WHITE);
		btn_Igu.setBackground(Color.BLUE);
		GridBagConstraints gbc_Igu = new GridBagConstraints();
		gbc_Igu.gridheight = 2;
		gbc_Igu.fill = GridBagConstraints.BOTH;
		gbc_Igu.insets = new Insets(0, 0, 7, 7);
		gbc_Igu.gridx = 4;
		gbc_Igu.gridy = 2;
		abajo.add(btn_Igu, gbc_Igu);

		JButton btn_C = new JButton("C");
		btn_C.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText("");
			}
		});
		btn_C.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_C.setBackground(Color.RED);
		btn_C.setForeground(Color.WHITE);
		GridBagConstraints gbc_C = new GridBagConstraints();
		gbc_C.fill = GridBagConstraints.BOTH;
		gbc_C.insets = new Insets(0, 0, 7, 7);
		gbc_C.gridx = 0;
		gbc_C.gridy = 3;
		abajo.add(btn_C, gbc_C);

		JButton btn0 = new JButton("0");
		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn0.getText());
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBackground(Color.LIGHT_GRAY);
		btn0.setForeground(Color.BLUE);
		GridBagConstraints gbc_0 = new GridBagConstraints();
		gbc_0.fill = GridBagConstraints.BOTH;
		gbc_0.insets = new Insets(0, 0, 7, 7);
		gbc_0.gridx = 1;
		gbc_0.gridy = 3;
		abajo.add(btn0, gbc_0);

		JButton btn_Punto = new JButton(".");
		btn_Punto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_Punto.getText());
			}
		});
		btn_Punto.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Punto.setBackground(Color.LIGHT_GRAY);
		btn_Punto.setForeground(Color.BLUE);
		GridBagConstraints gbc_Punto = new GridBagConstraints();
		gbc_Punto.fill = GridBagConstraints.BOTH;
		gbc_Punto.insets = new Insets(0, 0, 7, 7);
		gbc_Punto.gridx = 2;
		gbc_Punto.gridy = 3;
		abajo.add(btn_Punto, gbc_Punto);

		JButton btn_Suma = new JButton("+");
		btn_Suma.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				label.setText(label.getText() + btn_Suma.getText());
			}
		});
		btn_Suma.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_Suma.setBackground(Color.GRAY);
		btn_Suma.setForeground(Color.WHITE);
		GridBagConstraints gbc_Suma = new GridBagConstraints();
		gbc_Suma.fill = GridBagConstraints.BOTH;
		gbc_Suma.insets = new Insets(0, 0, 7, 7);
		gbc_Suma.gridx = 3;
		gbc_Suma.gridy = 3;
		abajo.add(btn_Suma, gbc_Suma);

		todoPanel.add(abajo, BorderLayout.SOUTH);
		todoPanel.add(arriba, BorderLayout.CENTER);

	}

	public boolean positivo_negativo() {
		boolean pos = true;
		String texto = label.getText();
		if (texto.startsWith(" -")) {
			pos = false;
		} else {
			pos = true;
		}
		return pos;
	}
	
}