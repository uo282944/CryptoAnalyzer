package org.ull.dap.modelo.persistence.crypto.impl;

import org.ull.dap.modelo.PersistenceException;
import org.ull.dap.modelo.persistence.crypto.CryptoGateway;
import org.ull.dap.modelo.persistence.crypto.assembler.CryptoAssembler;
import org.ull.dap.modelo.persistence.util.Conf;
import org.ull.dap.modelo.utils.Jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class CryptoGatewayImpl implements CryptoGateway {
    @Override
    public void add(CryptoDALDto cryptoDALDto){
        // TODO Auto-generated method stub

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("insert into TCryptos(id, nombre) values (?, ?)");
            pst.setString(1, cryptoDALDto.id);
            pst.setString(2, cryptoDALDto.nombre);

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
    public void update(CryptoDALDto userDALDto) {

    }

    @Override
    public Optional<CryptoDALDto> findById(String id) {
        // TODO Auto-generated method stub
        Optional<CryptoDALDto> crypto = null;

        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement(Conf.getInstance().getProperty("TUSERS_FINDBYID"));

            pst.setString(1, id);

            rs = pst.executeQuery();
            crypto = CryptoAssembler.toCryptoDALDto(rs);

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
        return crypto;
    }

    @Override
    public List<CryptoDALDto> findAll() {
        return null;
    }

    @Override
    public Optional<CryptoDALDto> findByNombre(String nombre) {
        Optional<CryptoDALDto> crypto;

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("select * from TCryptos where nombre=?");

            pst.setString(1, nombre);

            rs = pst.executeQuery();
            crypto = CryptoAssembler.toCryptoDALDto(rs);

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
        return crypto;
    }
}
