package altajugador;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * @author Víctor
 */
public class AltaJugador {

    static ArrayList<Jugador> losJugadores = new ArrayList();
    static boolean nick = false;
    static boolean passwd = false;
    static boolean old = false;

    public static void main(String[] args) {
        cargaJugadores();
        botonAlta();
    }

    public static void botonAlta() {

        JFrame fondo = new JFrame("+");
        JPanel alfa = new JPanel(new BorderLayout());
        JPanel este = new JPanel(new BorderLayout());
        JPanel oeste = new JPanel(new BorderLayout());
        JPanel oestearriba = new JPanel();
        JPanel oesteabajo = new JPanel();
        JPanel esteabajo = new JPanel();
        JPanel estearriba = new JPanel();

        JComboBox lista = new JComboBox();
        lista.addItem("This are the players: ");
        lista.setPrototypeDisplayValue("This are the players: ");
        losJugadores.stream().forEach((player) -> {
            lista.addItem(player.getNombre());
        });

        JLabel texto = new JLabel("Añade Jugador");
        JLabel textolista = new JLabel("Lista Jugadores");

        fondo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fondo.setSize(350, 100);
        fondo.setAlwaysOnTop(true);
        fondo.setVisible(true);
        fondo.setLocationRelativeTo(null);
        fondo.setResizable(false);

        JButton onemore = new JButton("+");
        onemore.setSize(15, 20);
        onemore.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                otroJugador();
                fondo.dispose();
            }
        });

        oestearriba.add(texto);
        oesteabajo.add(onemore);
        oeste.add(oestearriba, BorderLayout.NORTH);
        oeste.add(oesteabajo, BorderLayout.SOUTH);
        alfa.add(oeste, BorderLayout.WEST);

        estearriba.add(textolista);
        esteabajo.add(lista);
        este.add(estearriba, BorderLayout.NORTH);
        este.add(esteabajo, BorderLayout.SOUTH);
        alfa.add(este, BorderLayout.CENTER);
        fondo.getContentPane().add(alfa);

    }

    static void otroJugador() {

        JFrame frame = new JFrame("+");
        JPanel capa1 = new JPanel();

        capa1.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        frame.setAlwaysOnTop(true);
        frame.setSize(200, 200);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        JLabel nameText = new JLabel("Nombre: ", SwingConstants.RIGHT);
        JLabel pass1Text = new JLabel("Password: ", SwingConstants.RIGHT);
        JLabel pass2Text = new JLabel("PassCheck: ", SwingConstants.RIGHT);
        JLabel ageText = new JLabel("Edad: ", SwingConstants.RIGHT);
        JLabel falloDatos = new JLabel("     -     ", SwingConstants.CENTER);

        JTextField name = new JTextField();
        name.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                
                for (Jugador next : losJugadores) {
                    if (name.getText().toLowerCase().equals(next.nombre.toLowerCase()) || name.getText().length() < 3) {
                        name.setForeground(Color.red);
                        falloDatos.setText("¡No válido!");
                        nick = false;
                        break;
                    } else {
                        name.setForeground(Color.blue);
                        falloDatos.setText("     -     ");
                        nick = true;
                    }
                }
            }
        });
        JPasswordField pass = new JPasswordField();
        JPasswordField passComp = new JPasswordField();
        pass.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {
                passComp.setText("");
                if (pass.getPassword().length < 4) {
                    pass.setForeground(Color.red);
                } else {
                    pass.setForeground(Color.black);
                }
            }
        });
        passComp.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                if (Arrays.equals(pass.getPassword(), passComp.getPassword())) {
                    passComp.setForeground(Color.black);
                    falloDatos.setText("     -     ");
                } else {
                    passComp.setForeground(Color.red);
                    falloDatos.setText("Pass don't match!");
                }
            }
        });
        JTextField age = new JTextField();
        age.addKeyListener(new KeyAdapter() {

            @Override
            public void keyReleased(KeyEvent e) {

                try {
                    age.setForeground(Color.red);
                    if (Integer.parseInt(age.getText()) > 99 || Integer.parseInt(age.getText()) < 1) {
                        age.setForeground(Color.red);
                        falloDatos.setText("¡De 1 a 99 años!");
                        falloDatos.setForeground(Color.red);
                        old = false;
                    } else {
                        age.setForeground(Color.blue);
                        falloDatos.setText("     -     ");
                        falloDatos.setForeground(Color.black);
                        old = true;
                    }
                } catch (Exception ex) {
                    falloDatos.setForeground(Color.red);
                    falloDatos.setText("¡La edad en números!");
                    old = false;
                }
            }
        });

        JButton accept = new JButton("Registrar");
        //accept.setEnabled(true);

        accept.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                if (Arrays.equals(pass.getPassword(), passComp.getPassword())) {
                    passwd = true;
                }

                if (nick && passwd & old) {

                    try {
                        nuevoJugador(name.getText(), pass.getPassword(), Integer.parseInt(age.getText()));
                        frame.dispose();
                        AltaJugador.botonAlta();
                    } catch (Exception ex) {
                        falloDatos.setText("¡Revise los datos!");
                        falloDatos.setForeground(Color.red);
                    }
                } else {
                    falloDatos.setText("¡Revise los datos!");
                    falloDatos.setForeground(Color.red);
                }
            }
        });
        JButton cancel = new JButton("Cancelar");
        cancel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                frame.dispose();
                AltaJugador.botonAlta();
            }
        });
//COLOCACION COMPONENTES        
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        //c.insets=new Insets(0, 0, 0, 0);
        capa1.add(nameText, c);

        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 1;
        capa1.add(pass1Text, c);

        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 1;
        capa1.add(pass2Text, c);

        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 1;
        capa1.add(ageText, c);
        //FIN ETIQUETAS    
        c.gridx = 1;
        c.gridy = 0;
        //name.setColumns(5);
        capa1.add(name, c);

        c.gridx = 1;
        c.gridy = 1;
        //pass.setColumns(1);
        capa1.add(pass, c);

        c.gridx = 1;
        c.gridy = 2;
        capa1.add(passComp, c);

        c.gridx = 1;
        c.gridy = 3;
        c.fill = GridBagConstraints.NONE;
        age.setColumns(3);
        //c.weightx=1;
        capa1.add(age, c);
        //FIN CAMPOS    
        c.gridx = 0;
        c.gridy = 4;
        c.gridwidth = 2;

        capa1.add(falloDatos, c);
        //ETIQUETA ERROR    
        c.gridx = 0;
        c.gridy = 5;
        c.gridwidth = 1;
        capa1.add(accept, c);

        c.gridx = 1;
        c.gridy = 5;
        capa1.add(cancel, c);
        //FIN BOTONES    

        frame.getContentPane().add(capa1);
    }

    public static void nuevoJugador(String nombre, char[] pass, Integer edad) {

        Jugador leJoueur = new Jugador(nombre, pass, edad);

        losJugadores.add(leJoueur);
    }

    private static void cargaJugadores() {

        Jugador leJoueur1 = new Jugador("Pedro", 30);
        Jugador leJoueur2 = new Jugador("Maria25", 25);
        Jugador leJoueur3 = new Jugador("PepaPig", 24);
        Jugador leJoueur4 = new Jugador("Marta", 20);
        Jugador leJoueur5 = new Jugador("Luis", 66);

        losJugadores.add(leJoueur1);
        losJugadores.add(leJoueur2);
        losJugadores.add(leJoueur3);
        losJugadores.add(leJoueur4);
        losJugadores.add(leJoueur5);
    }
}
