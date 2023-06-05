#Windows env

default: build run

clear:
	rmdir /s /q classes

build:
	cd src
	dir /b /s *.java > sources.txt
	javac -d ./classes/ @sources.txt
	del sources.txt

run:
	cd classes && java Main
