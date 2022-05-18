package com.magadiflo.todoapp.mapper;

/**
 *
 * @param <I>, Dato de entrada
 * @param <O>, Dato de salida
 */
public interface IMapper <I, O> {

    O map(I in);

}
