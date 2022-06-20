USE [master]
GO
/****** Object:  Database [SchoolSite]    Script Date: 6/14/2022 8:32:30 PM ******/
CREATE DATABASE [SchoolSite]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'SchoolSite', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\SchoolSite.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'SchoolSite_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.SQLEXPRESS\MSSQL\DATA\SchoolSite_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [SchoolSite] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [SchoolSite].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [SchoolSite] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [SchoolSite] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [SchoolSite] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [SchoolSite] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [SchoolSite] SET ARITHABORT OFF 
GO
ALTER DATABASE [SchoolSite] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [SchoolSite] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [SchoolSite] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [SchoolSite] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [SchoolSite] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [SchoolSite] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [SchoolSite] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [SchoolSite] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [SchoolSite] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [SchoolSite] SET  DISABLE_BROKER 
GO
ALTER DATABASE [SchoolSite] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [SchoolSite] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [SchoolSite] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [SchoolSite] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [SchoolSite] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [SchoolSite] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [SchoolSite] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [SchoolSite] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [SchoolSite] SET  MULTI_USER 
GO
ALTER DATABASE [SchoolSite] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [SchoolSite] SET DB_CHAINING OFF 
GO
ALTER DATABASE [SchoolSite] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [SchoolSite] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [SchoolSite] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [SchoolSite] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
ALTER DATABASE [SchoolSite] SET QUERY_STORE = OFF
GO
USE [SchoolSite]
GO
/****** Object:  Table [dbo].[Admins]    Script Date: 6/14/2022 8:32:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Admins](
	[adminID] [int] NOT NULL,
	[adminUsername] [nvarchar](max) NOT NULL,
	[adminPassword] [nvarchar](max) NOT NULL,
	[isAdmin] [bit] NOT NULL
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Answers]    Script Date: 6/14/2022 8:32:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Answers](
	[answerID] [int] NOT NULL,
	[Answer] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Answers] PRIMARY KEY CLUSTERED 
(
	[answerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Lessons]    Script Date: 6/14/2022 8:32:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Lessons](
	[lessonID] [int] NOT NULL,
	[userID] [int] NOT NULL,
	[lessonName] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Lessons] PRIMARY KEY CLUSTERED 
(
	[lessonID] ASC,
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Questions]    Script Date: 6/14/2022 8:32:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Questions](
	[questionID] [int] IDENTITY(1,1) NOT NULL,
	[subject] [nvarchar](max) NOT NULL,
	[questions] [nvarchar](max) NOT NULL,
 CONSTRAINT [PK_Questions_1] PRIMARY KEY CLUSTERED 
(
	[questionID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 6/14/2022 8:32:30 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[userID] [int] IDENTITY(1,1) NOT NULL,
	[userName] [nvarchar](max) NOT NULL,
	[firstName] [nvarchar](max) NOT NULL,
	[lastName] [nvarchar](max) NOT NULL,
	[email] [nvarchar](20) NOT NULL,
	[userPassword] [nvarchar](max) NOT NULL,
	[isTeacher] [bit] NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Questions] ON 
GO
INSERT [dbo].[Questions] ([questionID], [subject], [questions]) VALUES (2, N'Mat', N'kolko 5 po 5')
GO
SET IDENTITY_INSERT [dbo].[Questions] OFF
GO
SET IDENTITY_INSERT [dbo].[Users] ON 
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (1, N'Ivan', N'Dimitrov', N'Dimitrov', N'dimitrov@gmail.com', N'dimitrov123', 1)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (2, N'dimo', N'dimo', N'dimo@abv.bg', N'dimo', N'dimo123', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (3, N'ivan', N'ivan', N'ivan', N'ivan@abv.bg', N'ivanov123', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (4, N'dimo', N'aleksiev', N'aleksiev', N'123', N'da', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (5, N'Pencho', N'Ivan', N'Ivanov', N'ivanov123@gmail.com', N'ivan123', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (6, N'Ivan', N'Dimov', N'Dimov', N'andrikov@gmail.com', N'123', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (7, N'ivan', N'ivan', N'ivanov', N'ivanov@gmail.com', N'ivan123', 0)
GO
INSERT [dbo].[Users] ([userID], [userName], [firstName], [lastName], [email], [userPassword], [isTeacher]) VALUES (9, N'ivan', N'dimov', N'abv.bg', N'petko', N'123', 0)
GO
SET IDENTITY_INSERT [dbo].[Users] OFF
GO
ALTER TABLE [dbo].[Lessons]  WITH CHECK ADD  CONSTRAINT [FK_Lessons_Users] FOREIGN KEY([userID])
REFERENCES [dbo].[Users] ([userID])
GO
ALTER TABLE [dbo].[Lessons] CHECK CONSTRAINT [FK_Lessons_Users]
GO
USE [master]
GO
ALTER DATABASE [SchoolSite] SET  READ_WRITE 
GO
