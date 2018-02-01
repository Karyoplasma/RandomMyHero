#NoEnv  ; Recommended for performance and compatibility with future AutoHotkey releases.
; #Warn  ; Enable warnings to assist with detecting common errors.
SendMode Input  ; Recommended for new scripts due to its superior speed and reliability.
SetWorkingDir %A_ScriptDir%  ; Ensures a consistent starting directory.

strHeroes := []
intHeroes := []
agiHeroes := []
allHeroes := []

Initialize(){
	global strHeroes, intHeroes, agiHeroes, allHeroes
	
	Loop, read, %A_ScriptDir%\heroList.txt
	{
		temp := StrSplit(A_LoopReadLine,"=")
		if (strHeroes[1] == ""){
			strHeroes := StrSplit(temp[2], ",")
			for x,y in strHeroes
				allHeroes[x] := y
		} else {
			if (agiHeroes[1] == ""){
				agiHeroes := StrSplit(temp[2], ",")
				for x,y in agiHeroes
					allHeroes[x + strHeroes.MaxIndex()] := y
			} else {
				intHeroes := StrSplit(temp[2], ",")
				for x,y in intHeroes
					allHeroes[x+ strHeroes.MaxIndex() + agiHeroes.MaxIndex()] := y
			}
		}
	}
	strHeroes := ShuffleArray(strHeroes)
	agiHeroes := ShuffleArray(agiHeroes)
	intHeroes := ShuffleArray(intHeroes)
	allHeroes := ShuffleArray(allHeroes)
	SoundPlay, initialized.mp3
}

ShuffleArray(MyArray){
	NewArray := []
	while MyArray.Haskey(1) {
		Random, n, 1, MyArray.MaxIndex()
		NewArray.Push(MyArray.RemoveAt(n))
	}
	return NewArray
}

RandomAll(){
	global allHeroes
	
	SoundPlay, random.mp3	
	Random, rand, 1, allHeroes.MaxIndex()
	SendInput, % allHeroes[rand]
	Sleep, 700
	SendInput, !{Enter}
}

RandomStr(){
	global strHeroes
	
	SoundPlay, strength.mp3	
	Random, rand, 1, strHeroes.MaxIndex()
	SendInput, % strHeroes[rand]
	Sleep, 700
	SendInput, !{Enter}
}

RandomAgi(){
	global agiHeroes
	
	SoundPlay, agility.mp3
	Random, rand, 1, agiHeroes.MaxIndex()
	SendInput, % agiHeroes[rand]
	Sleep, 700
	SendInput, !{Enter}
}

RandomInt(){
	global intHeroes
	
	SoundPlay, intelligence.mp3
	Random, rand, 1, intHeroes.MaxIndex()
	SendInput, % intHeroes[rand]
	Sleep, 700
	SendInput, !{Enter}	
}

Initialize()
^!1::RandomAll()
^!2::RandomInt()
^!3::RandomInt()
^!4::RandomInt()