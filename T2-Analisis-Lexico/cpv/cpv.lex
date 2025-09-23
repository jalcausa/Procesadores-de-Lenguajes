

%%

%int
// %debub

%%

[a-zA-Z]*[aeiouAEIOU][aeiouAEIOU]([a-zA-Z]*[aeiouAEIOU]+)?																	{return 1;}

([aeiouAEIOU]?[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])*[aeiouAEIOU] 													{return 2;}

[a-zA-Z]*[aeiouAEIOU][aeiouAEIOU][a-zA-Z]*[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]+										{return 3;}

([aeiouAEIOU]?[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ])*[aeiouAEIOU]?[bcdfghjklmnpqrstvwxyzBCDFGHJKLMNPQRSTVWXYZ]+		{return 4;}

[^]																															{}