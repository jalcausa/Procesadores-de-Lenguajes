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