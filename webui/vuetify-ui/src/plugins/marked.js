import { marked } from 'marked'
import hljs from 'highlight.js'

const markedRenderer = new marked.Renderer();

markedRenderer.code = (code, language) => {
    const validLang = !!(language && hljs.getLanguage(language));
    const highlighted = validLang ? hljs.highlight(language, code).value : code;
    return `<pre><div class="hljs ${language}">${highlighted}</div></pre>`;
};

marked.setOptions({
    renderer: markedRenderer,
    sanitize: true
});

export default marked
