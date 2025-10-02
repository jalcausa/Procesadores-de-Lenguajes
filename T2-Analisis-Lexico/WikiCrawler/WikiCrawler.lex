%%

%int

%xstate GALERIA

link = (href\=\"https?:[^\"]+\.)

img_ext = (jpg | jpeg | png | svg | gif | JPG | JPEG | PNG | SVG | GIF)
video_ext = ogv | OGV
audio_ext = ogg

destacado = Featured\spictures | Commons\:Valued\simages

//%debug

%%




\<ul\ class=\"gallery\ mw-gallery-traditional\"\>					{
																			yybegin(GALERIA);
																	}
{link}{audio_ext}													{WikiCrawler.nAudio++;}

<GALERIA> {
	{link}{img_ext}													{
																		WikiCrawler.nImg++;
																		WikiCrawler.enlacesImagenes.add(yytext().substring(6, yytext().length()-1));
																	}
	{link}{video_ext}												{	
																		WikiCrawler.nVideo++;
																		WikiCrawler.enlacesVideo.add(yytext().substring(6, yytext().length()-1));
																	}
	class\=\"ui-slider-handle\ ui-state-default						{WikiCrawler.nAudio++;}


	\<\/ul\>														{yybegin(YYINITIAL);}
	[^]																{}
}

[^]																	{}