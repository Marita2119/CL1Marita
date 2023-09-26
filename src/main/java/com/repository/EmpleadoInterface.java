package com.repository;

import java.util.List ;


import com.entidad.Empleado ;

public interface EmpleadoInterface
{
				public void agregarEmpleado(Empleado e);
				public void actualizarEmpleado(Empleado e);
				public Empleado obtenerEmpleado(int id);
				public void eliminarEmpleado(Empleado e);
				public List<Empleado> listarEmpleados();
}
