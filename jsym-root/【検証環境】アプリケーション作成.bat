@echo off
setlocal enabledelayedexpansion

:INPUT_START
echo +-------------------------------------------------------+
echo +                     【検証環境】                      +
echo +-------------------------------------------------------+
echo  作成対象を選択してください。
echo;
echo  1：ALL
set mode[1]=ALL
echo  2：jsym-comm
set mode[2]=jsym-comm
echo  3：jsym-assistant
set mode[3]=jsym-assistant
echo  4：jsym-backlendcost
set mode[4]=jsym-backlendcost
echo  5：jsym-businesscommon
set mode[5]=jsym-businesscommon
echo  6：jsym-home
set mode[6]=jsym-home
echo  7：jsym-infoservice
set mode[7]=jsym-infoservice
echo  8：jsym-master
set mode[8]=jsym-master
echo  9：jsym-newcat
set mode[9]=jsym-newcat
echo  a：jsym-prodorddep
set mode[a]=jsym-prodorddep
echo  b：jsym-returning
set mode[b]=jsym-returning
echo  c：jsym-salesentry
set mode[c]=jsym-salesentry
echo  d：jsym-shipping
set mode[d]=jsym-shipping
echo  e：jsym-sss
set mode[e]=jsym-sss
echo  f：jsym-stocktake
set mode[f]=jsym-stocktake
echo  g：jsym-transtna
set mode[g]=jsym-transtna
echo;
echo  他：中止
echo +-------------------------------------------------------+


set INPUT_SELECT=
set /P INPUT_SELECT=
 
if "%INPUT_SELECT%"=="" GOTO :INPUT_START

echo %INPUT_SELECT% | findstr /r "\<[0-9a-g]\>" >nul 2>&1
if errorlevel 1 (
  echo  中止します
  PAUSE
  GOTO :INPUT_END
)

set APP=
set APP=!!mode[%INPUT_SELECT%]!!

:INPUT_CONF
echo +-------------------------------------------------------+
echo  作成するのは[%APP%]でよろしいですか？
echo （y / n）
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
echo  完了しました。
echo +-------------------------------------------------------+

:INPUT_NEXT
echo +-------------------------------------------------------+
echo  続けて他の作成を行いますか？
echo （y / n）
echo +-------------------------------------------------------+
set CONF_NEXT=
set /P CONF_NEXT=
 
if "%CONF_NEXT%"== set CONF_NEXT=Y
if /I "%CONF_NEXT%"=="Y"  GOTO :INPUT_START

:INPUT_END

endlocal
EXIT