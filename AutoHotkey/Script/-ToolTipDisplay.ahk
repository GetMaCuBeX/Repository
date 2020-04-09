; =========================================================================================== [FUNCTION]
; RunToolTip (Text , [OP2, OP3, OP4, OP5]) [Optional Parameters/Default Values]
RunToolTip(GetText, @ToolTipTimeOut:="", @MousePosition:=True,  @X:="7", @Y:="0"){
@TimeOut := @ToolTipTimeOut=="" ? @ToolTipTimeOut_Default_Global  : @ToolTipTimeOut
    RunRemoveToolTip() ;--------------------------------------------------------------------- [CALL] [FUNCTION]
    if (@MousePosition)
        ToolTip, %GetText%, @X, @Y+=31
    else
        ToolTip, %GetText%, 7, 0
    SetTimer, RunRemoveToolTip, %@TimeOut%
}

; =========================================================================================== [FUNCTION]
RunTollTipHotkeyInfo(GetText:="", @ToolTipTimeOut:="", @MousePosition:=True){
@TimeOut := @ToolTipTimeOut=="" ? @ToolTipTimeOut_Default_Global : @ToolTipTimeOut
FormatTime, CurrentDateTime,, hh:mm:ss tt
MouseGetPos, mX, mY
; =========================================================================================== [TEXT]
SetText =
(
Hotkey: %A_ThisHotkey%
)
if not (GetText="")
    SetText := SetText "`n" "ToolTip: " GetText
SetText := SetText "`n`n" "Time: " CurrentDateTime
; =========================================================================================== [TEXT] [RETURN]
RunToolTip(SetText, @TimeOut, @MousePosition, mX, mY) ;-------------------------------------- [CALL] [FUNCTION]
}

; =========================================================================================== [FUNCTION]
RunTollTipDisplay(GetText:="", @ToolTipTimeOut:="", @MousePosition:=True){
@TimeOut := @ToolTipTimeOut=="" ? @ToolTipTimeOut_Default_Global  : @ToolTipTimeOut
MouseGetPos, mX, mY
RunToolTip(GetText, @TimeOut, @MousePosition, mX, mY) ;-------------------------------------- [CALL] [FUNCTION]
}

; =========================================================================================== [FUNCTION]
RunRemoveToolTip(){
ToolTip
}
