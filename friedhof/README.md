Pénteken a középső gyermekem egy problémával jött haza, melyből csináltam egy feladatot.
Ez tényleg egy alaptól felépítendő és összetett feladat. Ő azt mondta, hogy csinálja a grafikus részét, mert a backend-hez nem ért annyira (még csak középiskolás és nem tanulták), illetve Pyton-ban a frontendes részét megcsinálja, én meg esetleg meg tudnám-e csinálni a backendes részét...
Hát ma belevágtunk! :smile:
Lehet, hogy morbidnak tűnik, de a nyári szünetben diákként a város Városfenntartójánál dolgozik és az idén a városi temetőbe került (és itt merült fel a probléma) -, de valakinek ezt is el kell végeznie és eddig ezt manuálisan csinálták!
Tehát a feladat leírása:
##Temetői nyilvántartás

Ebben a feladatban egy temető sírjainak megváltási nyilvántartásás, és a sírok nyilvántartását kell megoldani.

Szükséges egy személy (Person). Ez tartalmaz egy nevet, egy születési és egy halálozási dátumot.

Tartalmaz egy sírhely osztályt, melyben a következő attribútumok szükségesek:

A megvalósítás a FriedhofService és FriedhofConrtoller osztályok segítségével történjen és az alap cím a: "/api/friedhof" legyen.

- azonosító (ez automatikusan generálódik),
- egy azonosító kódot, mely a paracella azonosítójából, a sor és oszlop számából áll (pl.: A-12-25);
- egy névből (ki váltotta meg a helyet);
- egy személylistából (kik vannak oda temetve);
- egy megváltási dátumból (erre akkor van szükség, ha már megújítás is volt a sírhelyen);
- egy lejárati dátumból (a megváltás lejáratának dátuma - LocalDate, ez, ha nincs kitöltve, akkor a megváltási dátum + 26 év);

Az aplikáció valósítsa meg a következőket:
- [x] lehessen új sírt felvenni (az azonosítókód nem lehet üres, de a többi nem kötelező elem, azokat a módosítás részen lehessen hozzáadni vagy módosítani);
- [x] lehessen sírt keresni azonosítókód, megváltó neve, és a sírban lévők neve alapján;
- [x] lehessen lekérni a parcellák alapján a sírokban lévők listáját;
- [x] lehessen lekérni a lejárt sírhelyek listáját (ami azt jelenti, hogy az adott évben lejáró sírok listáját jelenti);
- [x] lehessen azonosítókód (PathVariable) alapján lekérni az adatokat;
- [] lehessen azonosítókód (PathVariable) alapján módosítani az adatokat (pl.: új nevet felvenni a nevek listába);
- [x] lehessen törölni azonosítókód (PathVariable) alapján;
- [x] lehessen törölni a teljes adatbázist is (ez ugye a tesztelés miatt kell, az éles adatbázist nem lenne jó törölni).
  Mivel én is csak most csinálom, ezért nincsenek tesztek sem, mindenki csinálhat azt is tetszőlegesen, illetve az elnevezéseket is.