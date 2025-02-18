/**
 * 
 */

evaluarSesion();

function evaluarSesion(){
	var enlace= sessionStorage.getItem('enlace');
	var path = window.location.pathname;
	if (enlace != null && enlace == path) {
		sessionStorage.removeItem('enlace');
		window.location.href = "ServletLogin?accion=CERRAR";
		return;
	}
	sessionStorage.setItem('enlace', path);
	return;
} 