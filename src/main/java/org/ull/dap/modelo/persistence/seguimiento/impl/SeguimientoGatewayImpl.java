package org.ull.dap.modelo.persistence.seguimiento.impl;

import org.ull.dap.modelo.PersistenceException;
import org.ull.dap.modelo.persistence.crypto.CryptoGateway.CryptoDALDto;
import org.ull.dap.modelo.persistence.crypto.assembler.CryptoAssembler;
import org.ull.dap.modelo.persistence.seguimiento.SeguimientoGateway;
import org.ull.dap.modelo.persistence.seguimiento.assembler.SeguimientoAssembler;
import org.ull.dap.modelo.utils.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class SeguimientoGatewayImpl implements SeguimientoGateway {
    @Override
    public void add(SeguimientoDALDto seguimientoDALDto){
        // TODO Auto-generated method stub

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("insert into TSeguimientos(id, id_usuario, id_crypto) values (?, ?, ?)");
            pst.setString(1, seguimientoDALDto.id);
            pst.setString(2, seguimientoDALDto.id_usuario);
            pst.setString(3, seguimientoDALDto.id_crypto);
            pst.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch(SQLException e)
                { /* ignore */ }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch(SQLException e) { /* ignore */

                }
            }
        }

    }

    @Override
    public void remove(String id) {

    }

    @Override
    public void update(SeguimientoDALDto userDALDto) {

    }

    @Override
    public Optional<SeguimientoDALDto> findById(String id) {
        // TODO Auto-generated method stub
        Optional<SeguimientoDALDto> user = null;
        return user;
    }

    @Override
    public List<SeguimientoDALDto> findAll() {
        return null;
    }


    @Override
    public List<CryptoDALDto> findCryptosById(String id) {
        List<CryptoDALDto> cryptos = null;

        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("SELECT TCryptos.id, TCryptos.nombre \n" +
                    "FROM TSeguimientos\n" +
                    "JOIN TCryptos ON TSeguimientos.id_crypto = TCryptos.id\n" +
                    "WHERE TSeguimientos.id_usuario = ?;");

            pst.setString(1, id);

            rs = pst.executeQuery();
            cryptos = CryptoAssembler.toCryptoList(rs);

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch(SQLException e)
                { /* ignore */ }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch(SQLException e) {
                    /* ignore */
                }
            }
        }
        return cryptos;
    }

    @Override
    public void removeSeguimiento(String idUsuario, String idCrypto) {
        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("DELETE FROM TSeguimientos\n" +
                    "WHERE id_usuario = ?\n" +
                    "  AND id_crypto = (SELECT id FROM TCryptos WHERE nombre = ?);");
            pst.setString(1, idUsuario);
            pst.setString(2, idCrypto);

            pst.executeUpdate();

        } catch (SQLException e) {
            throw new PersistenceException(e);
        }
        finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch(SQLException e)
                { /* ignore */ }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch(SQLException e) { /* ignore */

                }
            }
        }
    }

    @Override
    public Optional<SeguimientoDALDto> findSeguimientoByIds(String idusuario, String idcrypto) {
        Optional<SeguimientoDALDto> seguimiento;

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("select * from TSeguimientos where id_usuario=? AND id_crypto=?");

            pst.setString(1, idusuario);
            pst.setString(2, idcrypto);

            rs = pst.executeQuery();
            seguimiento = SeguimientoAssembler.toSeguimientoDALDto(rs);

        } catch (SQLException e) {
            throw new PersistenceException(e);
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* ignore */ }
            }
            if (pst != null) {
                try {
                    pst.close();
                } catch (SQLException e) {
                    /* ignore */
                }
            }
        }
        return seguimiento;
    }
}
