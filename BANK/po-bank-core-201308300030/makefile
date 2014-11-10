# $Id: Makefile,v 1.2 2011/09/25 14:47:43 david Exp $

JAVADIR=
JARNAME=po-bank-core

all:
	(cd src; javac -encoding UTF-8 `find . -name \*.java`)
	(cd src; jar cvf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java`)

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
