-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Client :  127.0.0.1
-- Généré le :  Sam 21 Mai 2016 à 00:27
-- Version du serveur :  10.1.9-MariaDB
-- Version de PHP :  5.6.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `ejb`
--

-- --------------------------------------------------------

--
-- Structure de la table `administration`
--

CREATE TABLE `administration` (
  `Code_admin` int(10) NOT NULL,
  `password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `administration`
--

INSERT INTO `administration` (`Code_admin`, `password`) VALUES
(10, 'ilpazzo');

-- --------------------------------------------------------

--
-- Structure de la table `compostage`
--

CREATE TABLE `compostage` (
  `Code_compostage` int(11) NOT NULL,
  `Numero_compostage` int(10) NOT NULL,
  `Code_note` int(11) NOT NULL,
  `Note` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `compostage`
--

INSERT INTO `compostage` (`Code_compostage`, `Numero_compostage`, `Code_note`, `Note`) VALUES
(21, 154449, 54, 0),
(22, 747573, 55, 0),
(23, 460946, 16, 0),
(24, 625993, 17, 0),
(25, 312782, 18, 0),
(26, 114237, 19, 0),
(27, 966135, 20, 0),
(30, 267394, 3, 13),
(32, 564531, 5, 12.5),
(34, 664376, 1, 15),
(36, 210266, 2, 11),
(37, 611316, 4, 7.5),
(39, 224984, 11, 0),
(40, 906724, 12, 0),
(41, 271547, 13, 0),
(42, 266392, 14, 0),
(43, 811674, 15, 0),
(44, 104822, 6, 0),
(45, 495742, 7, 0),
(46, 305973, 8, 0),
(48, 853831, 10, 0),
(52, 984183, 9, 0),
(54, 797286, 31, 0),
(55, 727117, 32, 0);

-- --------------------------------------------------------

--
-- Structure de la table `enseignant`
--

CREATE TABLE `enseignant` (
  `CIN` int(8) NOT NULL,
  `Matricule_fiscale` int(10) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Adresse` varchar(85) NOT NULL,
  `Tel` int(8) NOT NULL,
  `Code_user` int(10) NOT NULL,
  `Password` varchar(35) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `enseignant`
--

INSERT INTO `enseignant` (`CIN`, `Matricule_fiscale`, `Nom`, `Prenom`, `Adresse`, `Tel`, `Code_user`, `Password`) VALUES
(8884336, 253321, 'Ali', 'Jendoubi', 'route gabes km 2.5', 96256314, 15, 'alij'),
(78666325, 258963, 'Amine', 'Kallel', 'Route saltnia', 99362124, 21, 'manou.k'),
(88752133, 123652, 'Mzali', 'Feten', 'Route mharza km 5', 98988714, 27, 'feten'),
(88843369, 884339, 'Adouni', 'Marwa', 'Route tunis km 10', 96226351, 25, 'manou.k'),
(888413366, 8884337, 'Ben abdallah', 'Fatma', 'Route teniour km 7,5', 97852364, 18, 'fatma');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

CREATE TABLE `etudiant` (
  `CIN` int(8) NOT NULL,
  `Num_inscription` int(12) NOT NULL,
  `Nom` varchar(20) NOT NULL,
  `Prenom` varchar(20) NOT NULL,
  `Adresse` varchar(85) NOT NULL,
  `Tel` int(8) NOT NULL,
  `Code_user` int(10) NOT NULL,
  `Password` varchar(35) NOT NULL,
  `Groupe` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `etudiant`
--

INSERT INTO `etudiant` (`CIN`, `Num_inscription`, `Nom`, `Prenom`, `Adresse`, `Tel`, `Code_user`, `Password`, `Groupe`) VALUES
(8884680, 14625338, 'Chebbi', 'Ahmed', 'Aeroport km 8', 97524287, 55, 'brigade', 1),
(33265311, 852493, 'Sliti', 'Kamel', 'Route sidi mansour km 6,5', 26351428, 97, 'kamel', 4),
(88963261, 22153264, 'Amine', 'Samet', 'Route sokra km 1.5', 25356214, 2215, 'samet', 3),
(89653471, 896531, 'Ben mrad', 'Mouna', 'Route mharza km 0,5', 21325642, 33, 'mouna', 3),
(89653472, 11528963, 'Ben amor', 'Kamel', 'Route sokra km 3', 55362987, 2216, 'brigade', 3),
(89653486, 896535, 'Kadri', 'Mariem', 'Route aeroport km 0,5', 21325642, 34, 'mariem', 3),
(89653931, 896598, 'Ben salah', 'Amina', 'Beb Bhar', 21325986, 39, '', 3),
(98632511, 885234, 'Boudawara', 'Manel', 'Route menzel chaker km 7', 96236125, 99, 'manel', 4);

-- --------------------------------------------------------

--
-- Structure de la table `groupe`
--

CREATE TABLE `groupe` (
  `Code_grp` int(5) NOT NULL,
  `Nom_grp` varchar(35) NOT NULL,
  `Abreviation` varchar(5) NOT NULL,
  `Niveau` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `groupe`
--

INSERT INTO `groupe` (`Code_grp`, `Nom_grp`, `Abreviation`, `Niveau`) VALUES
(1, 'Genie Logicielle', 'GLID', 1),
(2, 'Administration et securite reseaux', 'ASR', 1),
(3, 'Groupe 1', 'GI 1', 4),
(4, 'Groupe 2', 'GI 2', 4),
(6, 'Genie Logicielle', 'GLID', 13),
(7, 'Administration et securite reseaux', 'ASR', 13);

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

CREATE TABLE `matiere` (
  `Code_Mat` int(5) NOT NULL,
  `Libelle` varchar(25) NOT NULL,
  `VolumeC` float NOT NULL,
  `VolumeTD` float NOT NULL,
  `VolumeTP` float NOT NULL,
  `Coeffecient` float NOT NULL,
  `Credit` float NOT NULL,
  `Enseignant` int(8) NOT NULL,
  `Groupe` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `matiere`
--

INSERT INTO `matiere` (`Code_Mat`, `Libelle`, `VolumeC`, `VolumeTD`, `VolumeTP`, `Coeffecient`, `Credit`, `Enseignant`, `Groupe`) VALUES
(1, 'Analyse Numerique', 15, 15, 10, 2, 3, 8884336, 3),
(3, 'Francais', 15, 18, 15, 3, 2, 78666325, 3),
(12, 'Anglais', 15, 0, 0, 2, 1, 88752133, 3),
(17, 'Langage C', 18, 12, 20, 3, 5, 88843369, 3),
(19, 'Langage C', 18, 12, 20, 3, 5, 88843369, 4),
(20, 'Theorie de compilation', 12, 8, 10, 2.5, 3, 888413366, 4),
(21, 'Java', 17, 13, 15, 3, 4, 8884336, 4),
(22, 'Probabilite', 15, 12, 0, 2, 3, 78666325, 4);

-- --------------------------------------------------------

--
-- Structure de la table `niveau`
--

CREATE TABLE `niveau` (
  `Code_niv` int(10) NOT NULL,
  `Nom_niv` varchar(35) NOT NULL,
  `Nombre_grp` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `niveau`
--

INSERT INTO `niveau` (`Code_niv`, `Nom_niv`, `Nombre_grp`) VALUES
(1, '2 eme informatique', 2),
(4, '1 ere informatique', 2),
(13, '3 eme informatique', 2);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

CREATE TABLE `note` (
  `code` int(11) NOT NULL,
  `noteTP` float NOT NULL,
  `noteDS` float NOT NULL,
  `noteExamen` float NOT NULL,
  `notePresentielle` double NOT NULL,
  `Matiere` int(5) NOT NULL,
  `Etudiant` int(8) NOT NULL,
  `Session` int(5) NOT NULL,
  `Validite` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `note`
--

INSERT INTO `note` (`code`, `noteTP`, `noteDS`, `noteExamen`, `notePresentielle`, `Matiere`, `Etudiant`, `Session`, `Validite`) VALUES
(1, 7, 11, 15, 9, 1, 88963261, 1, 2),
(2, 9, 12, 11, 10.5, 1, 89653471, 1, 2),
(3, 15, 10.5, 13, 12, 1, 89653472, 1, 2),
(4, 14, 15, 7.5, 10, 1, 89653486, 1, 2),
(5, 11.5, 6.75, 12.5, 8, 1, 89653931, 1, 2),
(6, 0, 0, 0, 0, 3, 88963261, 1, 0),
(7, 0, 0, 0, 0, 3, 89653471, 1, 0),
(8, 0, 0, 0, 0, 3, 89653472, 1, 0),
(9, 0, 0, 0, 0, 3, 89653486, 1, 0),
(10, 0, 0, 0, 0, 3, 89653931, 1, 0),
(11, 0, 0, 0, 0, 12, 88963261, 1, 0),
(12, 0, 0, 0, 0, 12, 89653471, 1, 0),
(13, 0, 0, 0, 0, 12, 89653472, 1, 0),
(14, 0, 0, 0, 0, 12, 89653486, 1, 0),
(15, 0, 0, 0, 0, 12, 89653931, 1, 0),
(16, 0, 0, 0, 0, 17, 88963261, 1, 0),
(17, 0, 0, 0, 0, 17, 89653471, 1, 0),
(18, 0, 0, 0, 0, 17, 89653472, 1, 0),
(19, 0, 0, 0, 0, 17, 89653486, 1, 0),
(20, 0, 0, 0, 0, 17, 89653931, 1, 0),
(21, 0, 0, 0, 0, 19, 33265311, 1, 0),
(22, 0, 0, 0, 0, 19, 98632511, 1, 0),
(23, 0, 0, 0, 0, 20, 33265311, 1, 0),
(24, 0, 0, 0, 0, 20, 98632511, 1, 0),
(25, 17, 15.5, 0, 14, 21, 33265311, 1, 1),
(26, 14, 16, 0, 15, 21, 98632511, 1, 1),
(31, 0, 0, 0, 0, 22, 33265311, 1, 0),
(32, 0, 0, 0, 0, 22, 98632511, 1, 0),
(54, 0, 0, 0, 0, 17, 8846211, 1, 0),
(55, 0, 0, 0, 0, 17, 8846215, 1, 0);

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `Id_session` int(5) NOT NULL,
  `Libelle` varchar(30) NOT NULL,
  `Annee_Universitaire` year(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `session`
--

INSERT INTO `session` (`Id_session`, `Libelle`, `Annee_Universitaire`) VALUES
(1, 'Principale', 2016);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `administration`
--
ALTER TABLE `administration`
  ADD PRIMARY KEY (`Code_admin`);

--
-- Index pour la table `compostage`
--
ALTER TABLE `compostage`
  ADD PRIMARY KEY (`Code_compostage`),
  ADD UNIQUE KEY `Numero_compostage` (`Numero_compostage`,`Code_note`);

--
-- Index pour la table `enseignant`
--
ALTER TABLE `enseignant`
  ADD PRIMARY KEY (`CIN`),
  ADD UNIQUE KEY `Matricule_fiscale` (`Matricule_fiscale`),
  ADD UNIQUE KEY `Code_user` (`Code_user`);

--
-- Index pour la table `etudiant`
--
ALTER TABLE `etudiant`
  ADD PRIMARY KEY (`CIN`),
  ADD UNIQUE KEY `Num_inscription` (`Num_inscription`),
  ADD UNIQUE KEY `Code_user` (`Code_user`);

--
-- Index pour la table `groupe`
--
ALTER TABLE `groupe`
  ADD PRIMARY KEY (`Code_grp`);

--
-- Index pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD PRIMARY KEY (`Code_Mat`);

--
-- Index pour la table `niveau`
--
ALTER TABLE `niveau`
  ADD PRIMARY KEY (`Code_niv`);

--
-- Index pour la table `note`
--
ALTER TABLE `note`
  ADD PRIMARY KEY (`code`),
  ADD UNIQUE KEY `Matiere` (`Matiere`,`Etudiant`,`Session`);

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`Id_session`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `compostage`
--
ALTER TABLE `compostage`
  MODIFY `Code_compostage` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;
--
-- AUTO_INCREMENT pour la table `groupe`
--
ALTER TABLE `groupe`
  MODIFY `Code_grp` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `matiere`
--
ALTER TABLE `matiere`
  MODIFY `Code_Mat` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT pour la table `niveau`
--
ALTER TABLE `niveau`
  MODIFY `Code_niv` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- AUTO_INCREMENT pour la table `note`
--
ALTER TABLE `note`
  MODIFY `code` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=114;
--
-- AUTO_INCREMENT pour la table `session`
--
ALTER TABLE `session`
  MODIFY `Id_session` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
