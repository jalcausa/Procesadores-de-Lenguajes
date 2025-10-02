%%

%int

%{
	String cadena = "";
%}

imagen = class\=\"image\"
audio1 = class\=\"mwPlayerContainer\ k-player\"
audio2 = class\=\"unicode\ audiolink\"
video = class\=\"PopUpMediaTransform\"

img_ext = (jpg | jpeg | png | svg | gif | JPG | JPEG | PNG | SVG | GIF)
video_ext = ogv | OGV
link = href\=\"[^\"\ ]\.
destacado = Featured\spictures | Commons\:Valued\simages

%%

{imagen} {
	WikiCrawler.nImg++;
}

{audio1} | {audio2} {
	WikiCrawler.nAudio++;
}

{video} {
	WikiCrawler.nVideo++;
}

{link}{img_ext}\" {

	cadena = yytext().substring(6, yytext().length()-1);
	WikiCrawler.enlacesImagenes.add(cadena);
}

{link}{video_ext}\" {

	cadena = yytext().substring(6, yytext().length()-1);
	WikiCrawler.enlacesVideo.add(cadena);
}

{destacado} {
	if (!WikiCrawler.enlacesDestacados.contains(cadena)) {
		WikiCrawler.enlacesDestacados.add(cadena);
	}
}

[^]								{}

/*

Para contar imágenes, tengo que buscar solo dentro de la etiqueta <ul class="gallery mv-gallery-traditional"> y entrar en un estado y cuando lleguemos al cierre del ul volvemos al initial, cuando encontremos </ul>

Luego una vez estamos dentro del gallery buscamos donde empieza el gallery text <div class="gallerytext">

Ya dentro de gallery buscamos también enlaces de vídeo

*/