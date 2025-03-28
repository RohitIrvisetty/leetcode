function isValid(s: string): boolean {
    let len: number = s.length;
    let stack = [];
    let parenthesisMap = {
        '(': ')',
        '{': '}',
        '[': ']'
    };
    for (let i = 0; i < len; i++) {
        if (parenthesisMap[stack[stack.length - 1]] == s[i]) {
            stack.pop();
        } else {
            stack.push(s[i]);
        }
    }
    return stack.length == 0;
};