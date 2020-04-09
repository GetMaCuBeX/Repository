file_ccleaner64     = C:\Program Files\CCleaner\CCleaner64.exe
file_mspaint        = C:\Windows\System32\mspaint.exe
file_notepad        = C:\Windows\System32\notepad.exe

SplitPath, file_ccleaner64, 	@ccleaner64_ext
SplitPath, file_mspaint, 		@mspaint_ext
SplitPath, file_notepad, 		@notepad_ext

; file_ccleaner64_WT  := " ahk_exe " . @ccleaner64_ext
; file_mspaint_WT     := " ahk_exe " . @mspaint_ext
; file_notepad_WT     := " ahk_exe " . @notepad_ext

file_notepad_WT     := "Untitled - Notepad"





; SplitPath, A_ScriptFullPath, @name_ext, @dir, @ext, @name_no_ext, @drive

/*
SendInput, FullPath: %A_ScriptFullPath%`n
SendInput, Name: %@name_ext%`n
SendInput, Dir: %@dir%`n
SendInput, Name: %@name_no_ext%`n
SendInput, Ext: %@ext%`n
SendInput, Drive: %@drive%`n

FullPath: D:\AHK\Key Remapping\Test Hotkeys.ahk
Name: Test Hotkeys.ahk
Dir: D:\AHK\Key Remapping
Name: Test Hotkeys
Ext: ahk
Drive: D:
*/
