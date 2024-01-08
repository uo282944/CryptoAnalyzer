package org.ull.dap.modelo.persistence.user.impl;

import org.ull.dap.modelo.PersistenceException;
import org.ull.dap.modelo.persistence.user.UserGateway;
import org.ull.dap.modelo.persistence.user.assembler.UserAssembler;
import org.ull.dap.modelo.persistence.util.Conf;
import org.ull.dap.modelo.utils.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UserGatewayImpl implements UserGateway {
    @Override
    public void add(UserDALDto userDALDto){
        // TODO Auto-generated method stub

        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("insert into TUsers(id, nick, password, email) values (?, ?, ?, ?)");
            pst.setString(1, userDALDto.id);
            pst.setString(2, userDALDto.nick);
            pst.setString(3, userDALDto.password);
            pst.setString(4, userDALDto.email);
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
    public void update(UserDALDto userDALDto) {

    }

    @Override
    public Optional<UserDALDto> findById(String id) {
        // TODO Auto-generated method stub
        Optional<UserDALDto> user = null;

        Connection c = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement(Conf.getInstance().getProperty("TUSERS_FINDBYID"));

            pst.setString(1, id);

            rs = pst.executeQuery();
            user = UserAssembler.toUserDALDto(rs);

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
        return user;
    }

    @Override
    public List<UserDALDto> findAll() {
        return null;
    }

    @Override
    public Optional<UserDALDto> findByNick(String nick) {
        Optional<UserDALDto> user;

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("select * from TUsers where nick=?");

            pst.setString(1, nick);

            rs = pst.executeQuery();
            user = UserAssembler.toUserDALDto(rs);

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
        return user;
    }

    @Override
    public Optional<UserDALDto> findByEmail(String email) {
        Optional<UserDALDto> user;

        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            Connection c = Jdbc.getCurrentConnection();

            pst = c.prepareStatement("select * from TUsers where email=?");

            pst.setString(1, email);

            rs = pst.executeQuery();
            user = UserAssembler.toUserDALDto(rs);

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
        return user;
    }
}
