function lengthOfLastWord(s: string): number {
    let lastWord: string[] = s.trim().split(" ");
    return lastWord.at(-1).length;
};