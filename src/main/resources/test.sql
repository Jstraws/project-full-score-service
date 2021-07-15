INSERT INTO inst_classification (classification_id, name, sort_order)
VALUES (0, 'Woodwinds', 0),
       (1, 'Brass', 1),
       (2, 'Strings', 2),
       (3, 'Percussion', 3);

/*------------------------------------------------------------------*/

INSERT INTO instrument (instrument_id, name, inst_classification_classification_id)
VALUES (900, 'Cello', 2),
       (901, 'French Horn', 1),
       (902, 'Clarinet', 0),
       (903, 'Timpani', 3);


