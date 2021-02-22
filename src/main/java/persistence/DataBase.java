package persistence;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Arrendador;
import model.Arrendatario;
import model.Cobro;
import model.Contrato;
import model.RegistroFactura;
import model.Inmueble;
import model.TipoInmueble;
import model.Configuracion;
import model.CobrosCliente;

public class DataBase {

    /*public static Connection getConnection() { // local
        Connection con = null;
        String URL = "jdbc:mysql://localhost:3306/alquileres";
        try {
            con = DriverManager.getConnection(URL, "root", "prueba123");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }*/
    public static Connection getConnection() { // disco duro red
        Connection con = null;
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mariadb://192.168.1.34:3306/alquileres", "cliente", "Ignaciomarin-123");
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public static void closeConnection(Connection con) {
        try {
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static ArrayList<RegistroFactura> selectRegistroFacturaByDniArrendatarioAndIdInmueble(String dniArrendatario, int idInmueble) {
        Connection con = getConnection();
        ArrayList<RegistroFactura> array = new ArrayList<RegistroFactura>();
        try {
            PreparedStatement st = con.prepareStatement("select * from registroFactura where dniArrendatario = ? and idInmueble = ? order by fechaFactura desc");
            st.setString(1, dniArrendatario);
            st.setInt(2, idInmueble);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                array.add(new RegistroFactura(rs.getInt("idRegistroFactura"), rs.getInt("numeroFactura"), rs.getDate("fechaFactura").toLocalDate(), rs.getBoolean("cobrado"), rs.getBoolean("agua"), rs.getBoolean("luz")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static ArrayList<Inmueble> selectContratoJoinInmuebleByDniArrendatario(String dniArrendatario) {
        Connection con = getConnection();
        ArrayList<Inmueble> array = new ArrayList<Inmueble>();
        try {
            PreparedStatement st = con.prepareStatement("select * from contrato inner join inmueble on contrato.idInmueble=inmueble.idInmueble where dniArrendatario = ?");
            st.setString(1, dniArrendatario);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                array.add(new Inmueble(rs.getInt("idInmueble"), rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("localidad"), rs.getString("numeroInmueble"), rs.getString("letraInmueble"), TipoInmueble.valueOf(rs.getString("tipoInmueble"))));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static ArrayList<Arrendatario> selectAllArendatarios() {
        Connection con = getConnection();
        ArrayList<Arrendatario> array = new ArrayList<Arrendatario>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from arrendatario");
            while (rs.next()) {
                array.add(new Arrendatario(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nacionalidad"), rs.getString("nombreCalle"),rs.getString("numeroCalle"),rs.getString("localidad"),rs.getString("municipio")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }
    
    public static Arrendador selectArrendadorByIdArrendador(int idArrendador) {
        Connection con = getConnection();
        Arrendador arrendador = null;
        try {
            PreparedStatement st = con.prepareStatement("select * from arrendador where idArrendador = ?");
            st.setInt(1, idArrendador);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                arrendador = new Arrendador(rs.getInt("idArrendador"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nacionalidad"),
                rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("localidad"), rs.getString("municipio"), rs.getString("dni"),
                rs.getString("email"), rs.getString("codigoPostal"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return arrendador;
    }
    
    public static ArrayList<Arrendador> selectAllArrendadores() {
        Connection con = getConnection();
        ArrayList<Arrendador> array = new ArrayList<Arrendador>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from arrendador");
            while (rs.next()) {
                array.add(new Arrendador(rs.getInt("idArrendador"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nacionalidad"),
                rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("localidad"), rs.getString("municipio"), rs.getString("dni"),
                rs.getString("email"), rs.getString("codigoPostal")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static RegistroFactura selectRegistroFacturasUltimaFechaFacturaFacturaByDniArrendatarioAndIdInmueble(String dni, int idInmueble) {
        Connection con = getConnection();
        RegistroFactura registroFactura = null;
        try {
            PreparedStatement st = con.prepareStatement("select * from registroFactura where dniArrendatario= ? and idInmueble= ? order by fechaFactura desc LIMIT 1");
            st.setString(1, dni);
            st.setInt(2, idInmueble);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                registroFactura = new RegistroFactura(rs.getInt("idRegistroFactura"), rs.getInt("numeroFactura"), rs.getDate("fechaFactura").toLocalDate(), rs.getBoolean("cobrado"), rs.getBoolean("agua"), rs.getBoolean("luz"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return registroFactura;
    }

    public static void deleteRegistroFacturaByIdRegistroFactura(int inicioIdRegistroFactura, int finIdRegistroFactura) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM registroFactura WHERE idRegistroFactura BETWEEN ? AND ?;");
            st.setInt(1, inicioIdRegistroFactura);
            st.setInt(2, finIdRegistroFactura);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void insertRegistroFactura(String dniArrendatario, int idInmueble, int numeroFactura, LocalDate fechaFactura, boolean cobrado, boolean agua, boolean luz, int idContrato) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO registroFactura (dniArrendatario, idInmueble, numeroFactura, fechaFactura, cobrado, agua, luz, idContrato) VALUES (?,?,?,?,?,?,?, ?)");
            st.setString(1, dniArrendatario);
            st.setInt(2, idInmueble);
            st.setInt(3, numeroFactura);
            st.setDate(4, Date.valueOf(fechaFactura));
            st.setBoolean(5, cobrado);
            st.setBoolean(6, agua);
            st.setBoolean(7, luz);
            st.setInt(8, idContrato);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static Contrato selectContratoByDniArrendatarioAndIdInmueble(String dni, int idInmueble) {
        Connection con = getConnection();
        Contrato contrato = null;
        try {
            PreparedStatement st = con.prepareStatement("select * from contrato where dniArrendatario= ? and idInmueble= ? ");
            st.setString(1, dni);
            st.setInt(2, idInmueble);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                contrato = new Contrato(rs.getInt("idContrato"), rs.getString("dniArrendatario"), rs.getInt("idInmueble"), rs.getInt("duracionContrato"), rs.getDouble("precio1Inmueble"), rs.getDouble("precio2Inmueble"), rs.getInt("idArrendador"));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return contrato;
    }

    public static boolean insertArrendatario(String tipoPersona, String dni, String nombre, String apellidos, String nacionalidad, String nombreCalle, String numeroCalle, String localidad, String municipio) {
        Connection con = getConnection();
        if (tipoPersona.equals("Física")) {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO arrendatario (dni, nombre, apellidos, nacionalidad, nombreCalle, numeroCalle, localidad, municipio) VALUES (?,?,?, ?, ?, ?, ?, ?)");
                st.setString(1, dni);
                st.setString(2, nombre);
                st.setString(3, apellidos);
                st.setString(4, nacionalidad);
                st.setString(5, nombreCalle);
                st.setString(6, numeroCalle);
                st.setString(7, localidad);
                st.setString(8, municipio);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ya existe un arrendatario con esos datos");
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO arrendatario (dni, nombre, nacionalidad, nombreCalle, numeroCalle, localidad, municipio) VALUES (?,?,?, ?, ?, ?, ?)");
                st.setString(1, dni);
                st.setString(2, nombre);
                st.setString(3, nacionalidad);
                st.setString(4, nombreCalle);
                st.setString(5, numeroCalle);
                st.setString(6, localidad);
                st.setString(7, municipio);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Ya existe un arrendatario con esos datos");
                e.printStackTrace();
                return false;
            }
        }
        closeConnection(con);
        return true;
    }

    public static void deleteArrendatarioByDni(String dni) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM arrendatario WHERE dni = ? ;");
            st.setString(1, dni);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static boolean insertInmueble(String nombreCalle, String numeroCalle, String localidad, String numeroInmueble, TipoInmueble tipoInmueble, String letraInmueble) {
        Connection con = getConnection();
        if (tipoInmueble.equals(tipoInmueble.LOCAL)) {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO inmueble (nombreCalle, numeroCalle, localidad, tipoInmueble) VALUES (?,?,?,?)");
                st.setString(1, nombreCalle);
                st.setString(2, numeroCalle);
                st.setString(3, localidad);
                st.setString(4, tipoInmueble.toString());
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else if(tipoInmueble.equals(tipoInmueble.APARCAMIENTO)){
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO inmueble (nombreCalle, numeroCalle, localidad, numeroInmueble, tipoInmueble) VALUES (?,?,?, ?,?)");
                st.setString(1, nombreCalle);
                st.setString(2, numeroCalle);
                st.setString(3, localidad);
                st.setString(4, numeroInmueble);
                st.setString(5, tipoInmueble.toString());
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {
            try {
                PreparedStatement st = con.prepareStatement("INSERT INTO inmueble (nombreCalle, numeroCalle, localidad, numeroInmueble, tipoInmueble, letraInmueble) VALUES (?,?,?, ?, ?, ?)");
                st.setString(1, nombreCalle);
                st.setString(2, numeroCalle);
                st.setString(3, localidad);
                st.setString(4, numeroInmueble);
                st.setString(5, tipoInmueble.toString());
                st.setString(6, letraInmueble);
                st.executeUpdate();
                st.close();
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
        closeConnection(con);
        return true;
    }

    public static ArrayList<Inmueble> selectAllInmuebles() {
        Connection con = getConnection();
        ArrayList<Inmueble> array = new ArrayList<Inmueble>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from inmueble");
            while (rs.next()) {
                array.add(new Inmueble(rs.getInt("idInmueble"), rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("localidad"), rs.getString("numeroInmueble"),rs.getString("letraInmueble"), TipoInmueble.valueOf(rs.getString("tipoInmueble"))));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static void deleteInmuebleByIdInmueble(int idInmueble) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM inmueble WHERE idInmueble = ? ;");
            st.setInt(1, idInmueble);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static ArrayList<Inmueble> selectInmuebleByIdInmuebleNotInContrato() {
        Connection con = getConnection();
        ArrayList<Inmueble> inmuebles = new ArrayList<Inmueble>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from inmueble where idInmueble NOT IN (SELECT idInmueble FROM contrato)");
            while (rs.next()) {
                inmuebles.add(new Inmueble(rs.getInt("idInmueble"), rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("localidad"), rs.getString("numeroInmueble"), rs.getString("letraInmueble"), TipoInmueble.valueOf(rs.getString("tipoInmueble"))));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return inmuebles;
    }

    public static boolean insertContrato(String dni, int idInmueble, int duracionContrato, double precio1, double precio2, int idArrendador) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO contrato (dniArrendatario, idInmueble, duracionContrato, precio1Inmueble, precio2Inmueble, idArrendador) VALUES (?,?,?, ?, ?, ?)");
            st.setString(1, dni);
            st.setInt(2, idInmueble);
            st.setInt(3, duracionContrato);
            st.setDouble(4, precio1);
            st.setDouble(5, precio2);
            st.setInt(6, idArrendador);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        closeConnection(con);
        return true;
    }

    public static ArrayList<Contrato> selectAllContratosJoinArrendatariosJoinInmueble() {
        Connection con = getConnection();
        ArrayList<Contrato> array = new ArrayList<Contrato>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT c.idContrato, a.nombre, a.apellidos, i.nombreCalle, i.numeroCalle, i.numeroInmueble\n"
                    + "FROM contrato AS c "
                    + "JOIN arrendatario AS a ON a.dni = c.dniArrendatario "
                    + "JOIN inmueble AS  i ON i.idInmueble = c.idInmueble;");
            while (rs.next()) {
                array.add(new Contrato(rs.getInt("idContrato"), rs.getString("nombre"), rs.getString("apellidos"), rs.getString("nombreCalle"), rs.getString("numeroCalle"), rs.getString("numeroInmueble")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static void deleteContratoByIdContrato(int idContrato) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM contrato WHERE idContrato = ? ;");
            st.setInt(1, idContrato);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static ArrayList<Cobro> selectAllCobroByidRegistroFactura(int idRegistroFactura) {
        Connection con = getConnection();
        ArrayList<Cobro> array = new ArrayList<Cobro>();
        try {
            PreparedStatement st = con.prepareStatement("select * from cobro where idRegistroFactura = ? ");
            st.setInt(1, idRegistroFactura);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                array.add(new Cobro(rs.getInt("idCobro"), rs.getDate("fechaCobro").toLocalDate(), rs.getDouble("importe")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

    public static void insertCobro(int idRegistroFactura, LocalDate fechaCobro, double importe) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO cobro (idRegistroFactura, fechaCobro, importe) VALUES (?,?,?)");
            st.setInt(1, idRegistroFactura);
            st.setDate(2, Date.valueOf(fechaCobro));
            st.setDouble(3, importe);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void deleteCobroByIdCobro(int idCobro) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("DELETE FROM cobro WHERE idCobro = ? ;");
            st.setInt(1, idCobro);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void updateRegistroFacturaSetAguaWhereIdRegistroFactura(boolean agua, int idRegistroFactura) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("update registroFactura set agua = ? where idRegistroFactura = ?");
            st.setBoolean(1, agua);
            st.setInt(2, idRegistroFactura);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void updateRegistroFacturaSetLuzWhereIdRegistroFactura(boolean luz, int idRegistroFactura) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("update registroFactura set luz = ? where idRegistroFactura = ?");
            st.setBoolean(1, luz);
            st.setInt(2, idRegistroFactura);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void updateRegistroFacturaSetCobradoWhereIdRegistroFactura(boolean cobrado, int idRegistroFactura) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("update registroFactura set cobrado = ? where idRegistroFactura = ?");
            st.setBoolean(1, cobrado);
            st.setInt(2, idRegistroFactura);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static void updateConfiguracionSetIgicAndIrpfWhereIdConfiguracion(float irpf, float igic) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("update configuracion set irpf = ? , igic = ? where idConfiguracion = 1");
            st.setFloat(1, irpf);
            st.setFloat(2, igic);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static Configuracion selectConfiguracion() {
        Connection con = getConnection();
        Configuracion configuracion = null;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from configuracion");
            if (rs.next()) {
                do {
                    configuracion = new Configuracion(rs.getFloat("irpf"), rs.getFloat("igic"));
                } while (rs.next());
            } else {
                insertConfiguracion(1, (float) 0.20, (float) 0.07);
                configuracion = new Configuracion((float) 0.20, (float) 0.07);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return configuracion;
    }

    public static void insertConfiguracion(int idConfiguracion, float irpf, float igic) {
        Connection con = getConnection();
        try {
            PreparedStatement st = con.prepareStatement("INSERT INTO configuracion (idConfiguracion, irpf, igic) VALUES (?,?,?)");
            st.setInt(1, idConfiguracion);
            st.setFloat(2, irpf);
            st.setFloat(3, igic);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
    }

    public static double selectSUMCobroByIdRegistroFactura(int idRegistroFactura) {
        Connection con = getConnection();
        double importes = 0;
        try {
            PreparedStatement st = con.prepareStatement("select sum(importe) as importes from cobro where idRegistroFactura = ? ;");
            st.setInt(1, idRegistroFactura);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                importes = rs.getDouble("importes");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return importes;
    }

    public static ArrayList<CobrosCliente> selectSumCobrosCadaCliente(LocalDate fechaInicio, LocalDate fechaFin) {
        Connection con = getConnection();
        ArrayList<CobrosCliente> array = new ArrayList<CobrosCliente>();
        try {
            PreparedStatement st = con.prepareStatement(
                    "SELECT SUM(importe) AS importes, a.dni, a.nombre, a.apellidos "
                    + "FROM cobro AS c "
                    + "JOIN registroFactura AS r ON c.idRegistroFactura = r.idRegistroFactura "
                    + "JOIN arrendatario AS a ON r.dniArrendatario = a.dni "
                    + "WHERE c.fechaCobro BETWEEN ? AND ? "
                    + "GROUP BY r.dniArrendatario ");
            st.setString(1, fechaInicio.toString());
            st.setString(2, fechaFin.toString());
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                array.add(new CobrosCliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("apellidos"), rs.getDouble("importes")));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        closeConnection(con);
        return array;
    }

}
