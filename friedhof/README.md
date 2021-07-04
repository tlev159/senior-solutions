##Temetői nyilvántartás

Ebben a feladatban egy temető sírjainak megváltási nyilvántartásás, és a sírok nyilvántartását kell megoldani.

Szükséges egy személy (Person). Ez tartalmaz egy nevet, egy születési és egy halálozási dátumot.

Tartalmaz egy sírhely osztályt, melyben a következő attribútumok szükségesek:

A megvalósítás a FriedhofService és FriedhofConrtoller osztályok segítségével történjen és az alap cím a: "/api/friedhof" legyen.

- azonosító (ez automatikusan generálódik),
- egy azonosító kódot, mely a pracella azonosítójából, a sor és oszlop számából áll (pl.: A-12-25);
- egy névből (ki váltotta meg a helyet);
- egy személylistából (kik vannak oda temetve);
- egy lejárati dátumból (erre akkor van szükség, ha már megújítás is volt a sírhelyen); 
- egy lejárati dátumból (a megváltás lejáratának dátuma - LocalDate);

Az aplikáció valósítsa meg a következőket:
- lehessen új sírt felvenni;
- lehessen sírt keresni azonosítókód, megváltó neve, és a sírban lévők neve alapján;
- lehessen lekérni a parcellák alapján a sírokban lévők listáját;
- lehessen azonosítókód alapján módosítani az adatokat;
- lehessen törölni azonosítókód alapján.


