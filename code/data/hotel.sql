
-- DATABASE hotel
delete from utilisateur;
delete from role;




INSERT INTO `role` (`id`, `type_role`) VALUES
(1, 'Directeur de l�h�tel'),
(2, 'Directeur du restaurant'),
(3, 'Directeur d�h�bergement'),
(4, 'Chef de r�ception'),
(5, 'Gouvernante g�n�rale'),
(6, 'Chef de maintenance');


-- password = 123456
INSERT INTO `utilisateur` (`id`, `lastname`, login, `mail`, `firstname`, `password`, `id_role`) VALUES
(1, 'St-Pierre', 'jst-pierre', 'JeanSt-Pierre@jourrapide.com', 'Jean', '123456', 1),
(2, 'St-paul', 'jst-paul', 'JeanSt-Pierre@paul.com', 'Jean', '123456', 3);

