/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.Entity;

import com.puntodeventa.global.Util.Util;
import com.puntodeventa.services.DAO.CredAmortDAO;
import com.puntodeventa.services.DAO.ClienteDAO;
import com.puntodeventa.services.DAO.VentaDAO;
import java.math.BigInteger;

/**
 *
 * @author jehernandez
 */
public class EntityTester {

    public static void main(String[] args) {
        
        
        VentaDAO ventaDAO = new VentaDAO();
        ClienteDAO clienteDao = new ClienteDAO();
        
        Cliente cliente = clienteDao.selectCliente(BigInteger.valueOf(1));
        Venta venta = ventaDAO.selectVenta(BigInteger.valueOf(327680));
        
        
        
        CredAmortPK pk = new CredAmortPK();
        pk.setCveCliente(cliente.getCveCliente());
        pk.setIdFolio(venta.getIdFolio());
//        pk.setCliente(cliente);
//        pk.setVenta(venta);
        
        CredAmort amort = new CredAmort();
        amort.setCredAmortPK(pk);
        amort.setDateMov(Util.getDate());
        amort.setDebt(BigInteger.valueOf(300));
        amort.setDeposit(BigInteger.valueOf(150));
        
        CredAmortDAO amortDao = new CredAmortDAO();
        amortDao.saveCredAmort(amort);
        
        
        

    }
}
