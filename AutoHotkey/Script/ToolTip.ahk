; =========================================================================================== [VARIABLES]
; (-) Makes this timer run only once.
; (+ Value) The Timer repeat automatically every specified time.
Global @ToolTipTimeOut_Specify_Global = -5000
Global @ToolTipTimeOut_Default_Global = -2500
@FontSize := "s11"
@FontFamity := "Default"
; @FontFamity := "Lato"
; @FontFamity := "Microsoft Sans Serif"
ToolTipFont(@FontSize, @FontFamity) ;-------------------------------------------------------- [CALL] [FUNCTION]
; =========================================================================================== [FONT]
ToolTipFont(Options := "", Name := "", hwnd := "") {
    static hfont := 0
    if (hwnd = "")
        hfont := Options="Default" ? 0 : _TTG("Font", Options, Name), _TTHook()
    else
        DllCall("SendMessage", "ptr", hwnd, "uint", 0x30, "ptr", hfont, "ptr", 0)
}

ToolTipColor(Background := "", Text := "", hwnd := "") {
    static bc := "", tc := ""
    if (hwnd = "") {
        if (Background != "")
            bc := Background="Default" ? "" : _TTG("Color", Background)
        if (Text != "")
            tc := Text="Default" ? "" : _TTG("Color", Text)
        _TTHook()
    }
    else {
        VarSetCapacity(empty, 2, 0)
        DllCall("UxTheme.dll\SetWindowTheme", "ptr", hwnd, "ptr", 0
            , "ptr", (bc != "" && tc != "") ? &empty : 0)
        if (bc != "")
            DllCall("SendMessage", "ptr", hwnd, "uint", 1043, "ptr", bc, "ptr", 0)
        if (tc != "")
            DllCall("SendMessage", "ptr", hwnd, "uint", 1044, "ptr", tc, "ptr", 0)
    }
}

_TTHook() {
    static hook := 0
    if !hook
        hook := DllCall("SetWindowsHookExW", "int", 4
            , "ptr", RegisterCallback("_TTWndProc"), "ptr", 0
            , "uint", DllCall("GetCurrentThreadId"), "ptr")
}

_TTWndProc(nCode, _wp, _lp) {
    Critical 999
   ;lParam  := NumGet(_lp+0*A_PtrSize)
   ;wParam  := NumGet(_lp+1*A_PtrSize)
    uMsg    := NumGet(_lp+2*A_PtrSize, "uint")
    hwnd    := NumGet(_lp+3*A_PtrSize)
    if (nCode >= 0 && (uMsg = 1081 || uMsg = 1036)) {
        _hack_ = ahk_id %hwnd%
        WinGetClass wclass, %_hack_%
        if (wclass = "tooltips_class32") {
            ToolTipColor(,, hwnd)
            ToolTipFont(,, hwnd)
        }
    }
    return DllCall("CallNextHookEx", "ptr", 0, "int", nCode, "ptr", _wp, "ptr", _lp, "ptr")
}

_TTG(Cmd, Arg1, Arg2 := "") {
    static htext := 0, hgui := 0
    if !htext {
        Gui _TTG: Add, Text, +hwndhtext
        Gui _TTG: +hwndhgui +0x40000000
    }
    Gui _TTG: %Cmd%, %Arg1%, %Arg2%
    if (Cmd = "Font") {
        GuiControl _TTG: Font, %htext%
        SendMessage 0x31, 0, 0,, ahk_id %htext%
        return ErrorLevel
    }
    if (Cmd = "Color") {
        hdc := DllCall("GetDC", "ptr", htext, "ptr")
        SendMessage 0x138, hdc, htext,, ahk_id %hgui%
        clr := DllCall("GetBkColor", "ptr", hdc, "uint")
        DllCall("ReleaseDC", "ptr", htext, "ptr", hdc)
        return clr
    }
}






; =========================================================================================== [DISPLAY]

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
FormatTime, @CurrentDateTime,, hh:mm:ss tt
MouseGetPos, mX, mY
; =========================================================================================== [TEXT]
SetText =
(
Hotkey: %A_ThisHotkey%
)
if not (GetText="")
    SetText := SetText "`n" "ToolTip: " GetText
SetText := SetText "`n`n" "Time: " @CurrentDateTime
; =========================================================================================== [TEXT] [RETURN]
RunToolTip(SetText, @TimeOut, @MousePosition, mX, mY) ;-------------------------------------- [CALL] [FUNCTION]
}

; =========================================================================================== [FUNCTION]
RunTollTipDisplay(GetText:="", @ToolTipTimeOut:="", @MousePosition:=True){
@TimeOut := @ToolTipTimeOut=="" ? @ToolTipTimeOut_Default_Global  : @ToolTipTimeOut
MouseGetPos, mX, mY
RunToolTip(GetText, @TimeOut, @MousePosition, mX, mY) ;-------------------------------------- [CALL] [FUNCTION]
}

; =========================================================================================== [LABEL]
RunRemoveToolTip(){
ToolTip
}
