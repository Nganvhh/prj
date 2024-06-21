/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.List;

/**
 *
 * @author NganNganchimte
 */
public interface CommonTask<T> {
    int add(T obj);
    int update(T obj);
    int delete(T obj);
    List<T> getAll();
}
