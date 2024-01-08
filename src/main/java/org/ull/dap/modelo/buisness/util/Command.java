package org.ull.dap.modelo.buisness.util;


import org.ull.dap.modelo.BusinessException;

public interface Command<T> {

	T execute() throws BusinessException;
}
