Sparqlers


---------------------------------------------
1/2/13
Enable basic inference capabilities with "Assembler"





--------------------------------------------
1/2/13
How to page through a result set:  Use combinatin of "OFFSET 100" and "LIMIT 50"

# filename: ex120.rq

PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>

SELECT ?label
WHERE
{ ?s rdfs:label ?label . }
OFFSET 3
LIMIT 1


----------------------------------------------
How to query for selected columns
1/2/13

# filename: ex109.rq
#
# Note: Filter expression with "in" parameter
#

PREFIX dm:  <http://learningsparql.com/ns/demo#>
PREFIX db: <http://dbpedia.org/resource/>

SELECT ?s ?cost ?location
WHERE
{
    ?s dm:location ?location ;
         dm:cost ?cost .
           FILTER (?location IN (db:Montreal, db:Lisbon)) .
