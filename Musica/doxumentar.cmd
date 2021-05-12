@CHCP 65001 > NUL
@ECHO OFF

SET nombre=ControlCanciones
SET nombrepaquete=daw2020.album
SET rutapaquete=daw2020\album

SET OLDPATH=%PATH%
SET PATH=c:\java\doxygen;c:\java\graphviz;%PATH%
SET CLASSPATH=bin
SET JAVA_TOOL_OPTIONS=-Dfile.encoding=UTF-8

ECHO %nombre%
ECHO ---
ECHO.

doxygen 2> doxumentar.log

DIR dox

ECHO.
ECHO No documentados:
findstr /r /c:"not.*documented" < doxumentar.log | find /c "warning"

ECHO.

SET PATH=%OLDPATH%
PAUSE