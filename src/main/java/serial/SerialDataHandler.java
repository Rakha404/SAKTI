/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package serial;

/**
 *
 * @author galuh
 * @param <T>
 */
public interface SerialDataHandler<T> {
    void onDataRecive(T data);
}
