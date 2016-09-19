package com.ipartek.formacion.domain;

public class Constantes {

	public static final String SERVER   = "192.168.0.16";
	public static final String PORT     = "8080";
	public static final String APP_NAME = "HelloWebMaven";
	public static final String WEB_HOME = "http://"+SERVER+":"+PORT+"/"+APP_NAME+"/";
	
	//OPERACIONES
	public static final int OP_LIST   = 0;
	public static final int OP_DETAIL = 1;	
	public static final int OP_DELETE = 3;	
	public static final int OP_SEARCH = 5;
	public static final int OP_NEW    = 2;
	//public static final int OP_UPDATE = 4;
	public static final int OP_SAVE = 35;
	
	
	//VISTAS
	public static final String VIEW_PLANET_LIST = "planets/list.jsp";
	public static final String VIEW_PLANET_DETAIL = "planets/detail.jsp";
	
	//CONTROLADORES
	public static final String CONTROLLER_PLANETS = "planets";
	
	
	
}
