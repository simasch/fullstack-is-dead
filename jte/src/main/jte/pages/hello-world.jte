@template.layout.main(
active = "hello-world",
content = @`
    <h1>Hello World</h1>

    <form id="form" hx-post="/greet" hx-target="#greeting">
        <div class="mb-3">
            <label for="name" class="form-label">Your name</label>
            <input class="form-control"
                   type="text"
                   id="name"
                   name="name"/>
        </div>
        <div class="mb-3">
            <button type="submit" class="btn btn-primary mb-3">
                Say hello
            </button>
        </div>
    </form>

    <div id="greeting"
         hx-swap-oob="true">
        @template.fragments.greeting(greeting = null)
    </div>
`
)
