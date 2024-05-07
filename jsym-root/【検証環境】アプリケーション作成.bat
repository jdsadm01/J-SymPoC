@echo off
setlocal enabledelayedexpansion

:INPUT_START
echo +-------------------------------------------------------+
echo +                     �y���؊��z                      +
echo +-------------------------------------------------------+
echo  �쐬�Ώۂ�I�����Ă��������B
echo;
echo  1�FALL
set mode[1]=ALL
echo  2�Fjsym-comm
set mode[2]=jsym-comm
echo  3�Fjsym-assistant
set mode[3]=jsym-assistant
echo  4�Fjsym-backlendcost
set mode[4]=jsym-backlendcost
echo  5�Fjsym-businesscommon
set mode[5]=jsym-businesscommon
echo  6�Fjsym-home
set mode[6]=jsym-home
echo  7�Fjsym-infoservice
set mode[7]=jsym-infoservice
echo  8�Fjsym-master
set mode[8]=jsym-master
echo  9�Fjsym-newcat
set mode[9]=jsym-newcat
echo  a�Fjsym-prodorddep
set mode[a]=jsym-prodorddep
echo  b�Fjsym-returning
set mode[b]=jsym-returning
echo  c�Fjsym-salesentry
set mode[c]=jsym-salesentry
echo  d�Fjsym-shipping
set mode[d]=jsym-shipping
echo  e�Fjsym-sss
set mode[e]=jsym-sss
echo  f�Fjsym-stocktake
set mode[f]=jsym-stocktake
echo  g�Fjsym-transtna
set mode[g]=jsym-transtna
echo;
echo  ���F���~
echo +-------------------------------------------------------+


set INPUT_SELECT=
set /P INPUT_SELECT=
 
if "%INPUT_SELECT%"=="" GOTO :INPUT_START

echo %INPUT_SELECT% | findstr /r "\<[0-9a-g]\>" >nul 2>&1
if errorlevel 1 (
  echo  ���~���܂�
  PAUSE
  GOTO :INPUT_END
)

set APP=
set APP=!!mode[%INPUT_SELECT%]!!

:INPUT_CONF
echo +-------------------------------------------------------+
echo  �쐬����̂�[%APP%]�ł�낵���ł����H
echo �iy / n�j
echo +-------------------------------------------------------+
set CONF_SELECT=
set /P CONF_SELECT=
 
if "%CONF_SELECT%"== set CONF_SELECT=Y
if /I not "%CONF_SELECT%"=="Y"  GOTO :INPUT_START

set GRADLE_MODE=
if "%INPUT_SELECT%"=="2" (
  set GRADLE_MODE=:jar
  set APP=:%APP%
) else (
  set GRADLE_MODE=:bootWar
  set APP=:%APP%:%APP%-web
)
rem set APP=:%APP%
if "%INPUT_SELECT%"=="1" (
  set APP=
)

call ./createApp.bat %APP% %GRADLE_MODE% test > example1.log 2>&1
type example1.log

echo +-------------------------------------------------------+
echo  �������܂����B
echo +-------------------------------------------------------+

:INPUT_NEXT
echo +-------------------------------------------------------+
echo  �����đ��̍쐬���s���܂����H
echo �iy / n�j
echo +-------------------------------------------------------+
set CONF_NEXT=
set /P CONF_NEXT=
 
if "%CONF_NEXT%"== set CONF_NEXT=Y
if /I "%CONF_NEXT%"=="Y"  GOTO :INPUT_START

:INPUT_END

endlocal
EXIT