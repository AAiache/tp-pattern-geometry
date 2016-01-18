# Version 0.0.1

## Description

Version simpliste avec trois classes : Point, LineString, Polygon implémentant une interface "Geometry".

On met en place deux méthodes sur l'interface Geometry :

* isEmpty : indique si la géométrie est vide

## Choix de conception

* On évite les objets "null" (utilisation de NaN pour les coordonnées nulles, listes vides plutôt que listes nulle pour les Point, exteriorRing correspondant à une LineString vide pour les Polygones vides, etc.)
* On rend toutes les classes immuables, I.e. non modifiable après construction. Pourquoi? Tant qu'on n'a pas besoin de faire des modifications à la volée, ceci permettra de mettre en cache certaines opérations plus facilement (validation des structures, calculs des bbox, etc.)

## Bonne pratique

* On encapsule l'accès aux points de la LineString.

## Critique de la version

* DRY : L'implémentation de asText directement dans les classes rends délicats la mise en facteur du commun à Polygon.asText et LineString.asText.

```
for ( int i = 0; i < getExteriorRing().getNumPoints(); i++ ) {
    if ( i != 0 ){
        result += ",";
    }
    result += getExteriorRing().getPointN(i).getCoordinate() ;
}
```

* La construction des objets est fastidieuses (abscence de fabrique, voire de builder).

---

# Version 0.0.2

TODO : Extraire le code qui effectue la sérialisation en WKT.










